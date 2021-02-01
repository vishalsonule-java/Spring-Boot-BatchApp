package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.BatchRunDetails;

public interface BatchRunDetailsRepository extends JpaRepository<BatchRunDetails, Serializable> {

}
