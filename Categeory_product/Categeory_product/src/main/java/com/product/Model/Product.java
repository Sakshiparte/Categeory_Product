package com.product.Model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@Size(min =2,max = 10,message = "name should contain between 3 to 10 characters")
	private String productName;
	
	@Column(nullable = false)
	@Size(min =2,max = 10,message = "name should contain between 3 to 10 characters")
    @NotNull(message = "type is required")
	private String type;
	
	@Column
    private String price;
	
	@CreatedDate
	private Instant createdAt;
	
	@LastModifiedDate
	private Instant updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Categeory category;
	

	public Product() {}


	public Product(int id, String productName, String type, String price, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.productName = productName;
		this.type = type;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Instant getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}


	public Instant getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	


}
