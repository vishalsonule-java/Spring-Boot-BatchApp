package com.ashokit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer edTraceId;
	
	@Column(name="BENEFIT_AMT")
	private Double benefitAmt;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="CREATE_DT")
	private Date createDate;
	
	@Column(name="UPDATE_DT")
	private Date updateDate;
	
	@Column(name="DENAIL_REASON")
	private String denailReason;
	
	@Column(name="PLAN_START_DT")
	private Date planStartDate;
	
	@Column(name="PLAN_END_DT")
	private Date planEndDate;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	

}
