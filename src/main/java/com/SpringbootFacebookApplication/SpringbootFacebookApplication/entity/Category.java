package com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity;

import java.util.ArrayList;
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

@Entity
@Table(name="facebook_category")
public class Category {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int categoryId;

private String categoryTitle;

@Column(name = "cat_des" ,length=100,nullable = false)
private String categoryDescription;


@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "category")
private List<Post>list=new ArrayList<>();


public int getCategoryId() {
	return categoryId;
}


public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}


public String getCategoryTitle() {
	return categoryTitle;
}


public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}


public String getCategoryDescription() {
	return categoryDescription;
}


public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}


public List<Post> getList() {
	return list;
}


public void setList(List<Post> list) {
	this.list = list;
}


public Category(int categoryId, String categoryTitle, String categoryDescription, List<Post> list) {
	super();
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDescription = categoryDescription;
	this.list = list;
}


public Category() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
			+ categoryDescription + ", list=" + list + "]";
}



	
	
}
