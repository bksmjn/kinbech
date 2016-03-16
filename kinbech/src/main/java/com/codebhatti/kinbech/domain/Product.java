package com.codebhatti.kinbech.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	
	/*@Transient
	MultipartFile imageFile;*/
	
	@Transient
	@Column(name="imagepath")
	String imagePath;
	
	@Column(name="quantitywhenupload")
	Integer quantityWhenUpload;
	
	@Column(name="categoryid")
	Long categoryId;
	
	@Column(name="unitprice")
	Double unitPrice;
	
	@Column(name="producttype")
	//@Enumerated(EnumType.STRING)
	String productType;
	
	@Column(name="createdon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="modifiedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	
	@OneToMany(mappedBy="product", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<ProductCopy> productCopyList;

	public Product() {
		this.productCopyList=new ArrayList<>();
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/*public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}*/
	
	public List<ProductCopy> getProductCopyList() {
		return productCopyList;
	}

	public void setProductCopyList(List<ProductCopy> productCopyList) {
		this.productCopyList = productCopyList;
	}

	public String getProductAsString() {
		return "Product [productId=" + productId + ", sellerId=" + sellerId + ", title=" + title + ", description="
				+ description + ", imagePath=" + imagePath + ", quantityWhenUpload=" + quantityWhenUpload
				+ ", categoryId=" + categoryId + ", unitPrice=" + unitPrice + ", productType=" + productType
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", productCopyList=" + productCopyList
				+ "]";
	}
}
