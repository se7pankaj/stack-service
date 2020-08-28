package com.info.nokia.services.stackdbservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.nokia.services.stackdbservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	

}
