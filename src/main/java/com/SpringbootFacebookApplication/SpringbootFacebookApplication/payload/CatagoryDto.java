package com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload;

import javax.persistence.Column;
import javax.persistence.Id;

public class CatagoryDto {
	
private int categoryId;

private String categoryTitle;


private String categoryDescription;

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

public CatagoryDto(int categoryId, String categoryTitle, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDescription = categoryDescription;
}

public CatagoryDto() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "CatagoryDto [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
			+ categoryDescription + "]";
}
	

}
