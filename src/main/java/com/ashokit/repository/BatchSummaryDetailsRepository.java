package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.BatchSummaryDetails;

public interface BatchSummaryDetailsRepository extends JpaRepository<BatchSummaryDetails, Serializable> {

}
