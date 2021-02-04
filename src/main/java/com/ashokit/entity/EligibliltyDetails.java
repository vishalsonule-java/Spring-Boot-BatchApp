package com.ashokit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ELIGIBILITY_DETAILS")
public class EligibliltyDetails implements Serializable {

	
	private static final long serialVersionUID = -5280941795964284339L;
	
	@Id
	@Column(name="ED_TRACE_ID")
	@GeneratedValue
	private Integer edTraceId;
	
	@Column(name="BENEFIT_AMT")
	private String benefitAmt;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="CREATE_DT")
	private String createDate;
	
	@Column(name="UPDATE_DT")
	private String updateDate;
	
	@Column(name="DENIAL_REASON")
	private String denailReason;
	
	@Column(name="PLAN_START_DT")
	private String planStartDate;
	
	@Column(name="PLAN_END_DT")
	private String planEndDate;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	

}
