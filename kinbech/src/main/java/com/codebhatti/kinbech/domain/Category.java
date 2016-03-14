package com.codebhatti.kinbech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORY_ID")
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	public Category() {}

	public Category(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + "]";
	}
}
