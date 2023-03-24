package com.SpringbootFacebookApplication.SpringbootFacebookApplication.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao.CategoryDao;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Category;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.exception.ResourceNotFoundException;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.CatagoryDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	// dao
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ModelMapper modelMapper;

	public CatagoryDto craetecategory(CatagoryDto categorydto) {
		// TODO Auto-generated method stub

		Category category = this.categorydtotoCategoryentity(categorydto);

		Category newcategory = categoryDao.save(category);

		CatagoryDto categoryresponse = this.CategoryentitytoCategorydto(newcategory);

		return categoryresponse;
	}

	// categorydtotocatgoryentity

	public List<Category> categorydtotoCategoryentity(List<CatagoryDto> catagoryDto) {

		List<Category> categoryCategories = catagoryDto.stream().map(dto -> this.categorydtotoCategoryentity(dto))
				.collect(Collectors.toList());

		return categoryCategories;

	}

	// catgoryentitycategorydtoto

	public List<CatagoryDto> Categoryentitycategorydtoto(List<Category> catagoryDto) {

		List<CatagoryDto> categoryCategories = catagoryDto.stream().map(dto -> this.CategoryentitytoCategorydto(dto))
				.collect(Collectors.toList());

		return categoryCategories;

	}

	// categorydtotocatgoryentity

	public Category categorydtotoCategoryentity(CatagoryDto catagoryDto) {
		return this.modelMapper.map(catagoryDto, Category.class);
	}

	public CatagoryDto CategoryentitytoCategorydto(Category catagory) {
		return this.modelMapper.map(catagory, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getAllCatagory() {

		List<Category> category = categoryDao.findAll();

		List<CatagoryDto> categorydtos = this.Categoryentitycategorydtoto(category);
		return categorydtos;

		
	}

	@Override
	public CatagoryDto getById(int catagoryId) {
		
		
		Optional<Category> categoryentity = categoryDao.findById(catagoryId);

		if (categoryentity.isPresent()) {
			Category category = categoryentity.get();
			return this.CategoryentitytoCategorydto(category);
		} else {
			throw new ResourceNotFoundException("this is inform you" + catagoryId + "is not presnt");
		}
	}

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagorydto, int catagoryId) {
		
		
	Category categoryentity = categoryDao.findById(catagoryId).get();
	
	
	categoryentity.setCategoryTitle(catagorydto.getCategoryTitle());
	categoryentity.setCategoryDescription(catagorydto.getCategoryDescription());
	
	Category category= categoryDao.save(categoryentity);
	
	return this.CategoryentitytoCategorydto(category);
	}

	@Override
	public void delteCatagory(int catagoryId) {
		

		Optional<Category> categoryentity = categoryDao.findById(catagoryId);

		if (categoryentity.isPresent()) {
			Category category = categoryentity.get();
			categoryDao.delete(category);
		} else {
			throw new ResourceNotFoundException("this is inform you" + catagoryId + "is not presnt");
		}
	}

}
