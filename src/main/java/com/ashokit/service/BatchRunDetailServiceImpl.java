package com.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.BatchRunDetails;
import com.ashokit.entity.BatchSummaryDetails;
import com.ashokit.entity.CoPdfs;
import com.ashokit.entity.CoTrigger;
import com.ashokit.entity.EligibliltyDetails;
import com.ashokit.repository.BatchRunDetailsRepository;
import com.ashokit.repository.BatchSummaryDetailsRepository;
import com.ashokit.repository.CoPdfsRepositroy;
import com.ashokit.repository.CoTriggersRepository;
import com.ashokit.repository.EligiblityDetailsRepository;

@Service
public class BatchRunDetailServiceImpl implements BatchRunDetailService {
	
	@Autowired
	private BatchRunDetailsRepository batchRunDetailsRepo;
	
	@Autowired
	private BatchSummaryDetailsRepository batchSummaryDetailsRepo;
	
	@Autowired
	private CoTriggersRepository coTriggersRepo; 
	
	@Autowired
	private EligiblityDetailsRepository eligiblityDetailsRepo; 
	
	@Autowired
	private CoPdfsRepositroy coPdfsRepo;
	

	@Override
	public BatchRunDetails saveBatchRunDtails(BatchRunDetails batchRunDetials) {
	return batchRunDetailsRepo.save(batchRunDetials);
	}

	@Override
	public BatchRunDetails getBatchRunDetailsBySeq(Integer seq) {
		return batchRunDetailsRepo.findById(seq).get();
	}

	@Override
	public BatchSummaryDetails saveBatchSummaryDetails(BatchSummaryDetails batchSummaryDetails) {
		return batchSummaryDetailsRepo.save(batchSummaryDetails);
	}

	@Override
	public List<CoTrigger> getCoTriggerByStatus() {
		return coTriggersRepo.findByTrgStatus("P");
	}

	@Override
	public EligibliltyDetails getEligiblityDetailsByCaseNumber(Integer caseNum) {
		return eligiblityDetailsRepo.findBycaseNum(caseNum);
	}

	@Override
	public CoPdfs savePdf(CoPdfs coPdfs) {
		return coPdfsRepo.save(coPdfs);
	}

	@Override
	public CoTrigger updateCoTrigger(CoTrigger coTrigger) {
		return coTriggersRepo.save(coTrigger);
	}

}
