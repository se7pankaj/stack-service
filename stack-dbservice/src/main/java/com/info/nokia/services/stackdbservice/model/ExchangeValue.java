package com.info.nokia.services.stackdbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stack")
public class ExchangeValue {
	@Id
	private Long id;
	
	@Column(name="stack_element")
	private String element;
	
	public ExchangeValue() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public ExchangeValue(Long id, String element) {
		super();
		this.id = id;
		this.element = element;
	}
	
}
