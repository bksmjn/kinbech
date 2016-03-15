package com.codebhatti.kinbech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.codebhatti.kinbech.enums.ProductStatus;

@Entity
@Table(name="ProductCopy")
public class ProductCopy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCTCOPY_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	
	@Column(name="PRODUCT_STATUS")
	private String productStatus="NOT_SOLD";
	//private ProductStatus productStatus=ProductStatus.NOT_SOLD;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="buyer")
	private User buyer;
	
	public ProductCopy() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

}
