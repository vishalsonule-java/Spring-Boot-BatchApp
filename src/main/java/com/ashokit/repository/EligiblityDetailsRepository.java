package com.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.EligibliltyDetails;

public interface EligiblityDetailsRepository extends JpaRepository<EligibliltyDetails, Serializable> {

}
