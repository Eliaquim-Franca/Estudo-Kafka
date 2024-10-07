package org.rabbitmq.commons.dtos;

import java.io.Serializable;

public class ProductDTO implements Serializable{
	
	private Integer id;
	private String name;
	private Double price;
	
	public ProductDTO(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO() {};
	
}
