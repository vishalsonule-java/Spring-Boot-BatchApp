package com.ashokit.batches;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.BatchRunDetails;
import com.ashokit.entity.BatchSummaryDetails;
import com.ashokit.entity.CoPdfs;
import com.ashokit.entity.CoTrigger;
import com.ashokit.entity.EligibliltyDetails;
import com.ashokit.service.BatchRunDetailService;
import com.ashokit.service.PDFService;

@Component
public class CoGenDlyBatch {
	@Autowired
	private PDFService pdfService;
	
	private static final String BATCH_NAME="CO_GEN_DLY";
	
	private static int Fail_trg_cunt=0;
	private static int Succ_trg_cunt=0;
	
	@Autowired
	private BatchRunDetailService batchRunDetailService;
	
	public String Test() {
		Integer id = this.preProcess();
		this.start();
		this.postProcess(id);
		return "batch excuted";
	}

	public Integer preProcess() {
		BatchRunDetails batchRunDetails= new BatchRunDetails();
		batchRunDetails.setBatchName(BATCH_NAME);
		batchRunDetails.setBatchRunStatus("ST");
		batchRunDetails.setStartDate(new Date());
		batchRunDetails= batchRunDetailService.saveBatchRunDtails(batchRunDetails);
		return batchRunDetails.getBatchRunSeq();
	}
	
	public void postProcess(Integer id) {
		//update records in BATCH_RUN_DTL table with batch end time
		BatchRunDetails batchRunDetailsBySeq = batchRunDetailService.getBatchRunDetailsBySeq(id);
		batchRunDetailsBySeq.setEndDate(new Date());
		batchRunDetailsBySeq.setBatchRunStatus("ED");
		batchRunDetailService.saveBatchRunDtails(batchRunDetailsBySeq);
		
		//Insert batch summary in BATCH_SUMMARY table
		BatchSummaryDetails batchSummaryDetails= new BatchSummaryDetails();
		batchSummaryDetails.setBatch_name(batchRunDetailsBySeq.getBatchName());
		batchSummaryDetails.setFailureTriggerCount(Fail_trg_cunt);
		batchSummaryDetails.setSuccessTriggerCount(Succ_trg_cunt);
		batchSummaryDetails.setTotalTriggerProcessed(Fail_trg_cunt + Succ_trg_cunt);
		batchRunDetailService.saveBatchSummaryDetails(batchSummaryDetails);
		
	}
	
	public void start() {
		//retrieve all triggers which are in pending status
		List<CoTrigger> coTriggerByStatus = batchRunDetailService.getCoTriggerByStatus();
		
		//  call process method to process each records
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		ExecutorCompletionService<Object> pool= new ExecutorCompletionService<Object>(executorService);
		
		coTriggerByStatus.forEach(trigger->{
			pool.submit(new Callable<Object>() {
				
				@Override
				public Object call() throws Exception {
					process(trigger);
					return null;
				}
			});
			
		});
	}
	
	public void process(CoTrigger trigger) {
		String pdf=null;
		try {
			//Retrieve eligibility  details using case no
			EligibliltyDetails eligiblityDetailsByCaseNumber = batchRunDetailService.getEligiblityDetailsByCaseNumber(trigger.getCaseNo());
			//generate pdf using itext api based plan status
			String planStatus= eligiblityDetailsByCaseNumber.getPlanStatus();
			if(planStatus.equalsIgnoreCase("AP")) {
				 pdf = pdfService.createAPPdf(eligiblityDetailsByCaseNumber);
			}
			else if(planStatus.equalsIgnoreCase("DN")) {
				pdf = pdfService.createDNPdf(eligiblityDetailsByCaseNumber);
			}
			//store pdf in table
			CoPdfs pdfs= new CoPdfs();
			pdfs.setCaseNumber(eligiblityDetailsByCaseNumber.getCaseNum());
			pdfs.setPdf(pdf);
			pdfs.setPlanName(eligiblityDetailsByCaseNumber.getPlanName());
			pdfs.setPlanStatus(eligiblityDetailsByCaseNumber.getPlanStatus());
			batchRunDetailService.savePdf(pdfs);
			
			//update trigger as completed
			trigger.setTrgStatus("C");
			trigger.setUpdatedDate(new Date());
			batchRunDetailService.updateCoTrigger(trigger);
			Succ_trg_cunt=Succ_trg_cunt+1;
			System.out.println(Succ_trg_cunt);
		}
		catch(Exception e) {
			e.printStackTrace();
			Fail_trg_cunt=Fail_trg_cunt+1;
		}
	}
}
