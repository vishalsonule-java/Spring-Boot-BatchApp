package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.batches.CoGenDlyBatch;

@RestController
public class EDRestController {

	@Autowired
	private CoGenDlyBatch batch;
	
	@GetMapping("/testBatch")
	public String handleBatchExcution() {
		return batch.Test();
	}
}
