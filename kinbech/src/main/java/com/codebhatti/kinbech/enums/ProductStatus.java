package com.codebhatti.kinbech.enums;

public enum ProductStatus {
	NOT_SOLD("NOT_SOLD"),
	SOLD("SOLD");
	
	private String status;
	
	private ProductStatus(String status) {
		this.status=status;
	}
	
	@Override
	public String toString() {
		return this.name();
	}	
}
