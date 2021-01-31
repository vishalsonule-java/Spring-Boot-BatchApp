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
@Table(name="CO_TRIGGERS")
public class CoTriggers implements Serializable {

	
	private static final long serialVersionUID = -3128624627092122258L;
	
	@Column(name="TRG_ID")
	@Id
	private Integer trgId;
	
	@Column(name="CASE_NUM")
	private Integer caseNo;
	
	@Column(name="CREATE_DT")
	private Date createdDate;
	
	@Column(name="UPDATE_DT")
	private Date updatedDate;
	
	@Column(name="TRG_STATUS")
	private String trgStatus;

}
