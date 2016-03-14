package com.codebhatti.kinbech.enums;

public enum ProductType {
	NEW("New"),
	USED("Used"),
	REFURBISHED("Refurbished");
	
	private String name;
	
	private ProductType(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}
