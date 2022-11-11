package com.example.demo;

import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Auditlistner {
	private static Logger LOGGER = LoggerFactory.getLogger(Econtroller.class);
	@SuppressWarnings("deprecation")
	@PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyOperation(Object object) { 
		LOGGER.info(object.toString());
		LOGGER.info("Before-Operation--->{}",(new Date()).toLocaleString());
	}
	
	
}
