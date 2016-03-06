package com.codebhatti.kinbech.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author tek
 *
 */
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
	Long productId;

	@Column(name="sellerid")
	String sellerId;
	
	@Column(name="title")
	String title;
	
	@Column(name="description")
	String description;
	
	@Column(name="imagepath")
	String imagePath;
	
	@Column(name="quantitywhenupload")
	Integer quantityWhenUpload;
	
	@Column(name="categoryid")
	Long categoryId;
	
	@Column(name="unitprice")
	Double unitPrice;
	
	@Column(name="createdon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="modifiedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	public Product() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getQuantityWhenUpload() {
		return quantityWhenUpload;
	}

	public void setQuantityWhenUpload(Integer quantityWhenUpload) {
		this.quantityWhenUpload = quantityWhenUpload;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
