package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.BatchRunDetails;
import com.ashokit.entity.BatchSummaryDetails;
import com.ashokit.entity.CoPdfs;
import com.ashokit.entity.CoTrigger;
import com.ashokit.entity.EligibliltyDetails;
import com.ashokit.repository.EligiblityDetailsRepository;

public interface BatchRunDetailService {
public BatchRunDetails saveBatchRunDtails(BatchRunDetails batchRunDetials);
public BatchRunDetails getBatchRunDetailsBySeq(Integer seq);
public BatchSummaryDetails saveBatchSummaryDetails(BatchSummaryDetails batchSummaryDetails);
public List<CoTrigger> getCoTriggerByStatus();
public EligibliltyDetails getEligiblityDetailsByCaseNumber(Integer caseNum);
public CoPdfs savePdf(CoPdfs coPdfs);
public CoTrigger updateCoTrigger(CoTrigger coTrigger);
}
