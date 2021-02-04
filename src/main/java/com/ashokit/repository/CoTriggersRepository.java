package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.CoTrigger;

public interface CoTriggersRepository extends JpaRepository<CoTrigger, Serializable> {

	public List<CoTrigger> findByTrgStatus(String status);
}
