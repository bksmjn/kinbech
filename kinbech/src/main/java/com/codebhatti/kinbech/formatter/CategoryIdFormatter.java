package com.codebhatti.kinbech.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CategoryIdFormatter implements Formatter<Long> {

	@Override
	public String print(Long categoryId, Locale locale) {
		return String.valueOf(categoryId);
	}

	@Override
	public Long parse(String categoryId, Locale locale) throws ParseException {
		return Long.valueOf(categoryId);
	}

}
