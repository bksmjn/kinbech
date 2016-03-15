package com.codebhatti.kinbech.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.codebhatti.kinbech.enums.ProductType;

public class ProductTypeFormatter implements Formatter<ProductType> {

	@Override
	public String print(ProductType object, Locale locale) {
		return object.name();
	}

	@Override
	public ProductType parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
