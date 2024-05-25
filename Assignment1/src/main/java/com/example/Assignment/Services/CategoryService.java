package com.example.Assignment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment.Entity.Category;
import com.example.Assignment.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	//Create
	public Category CreateRepository(Category cat) {
		return this.categoryRepo.save(cat);
		
	}
	
	//Get a List Of Category
	public List<Category> getAllCategories(){
		return this.categoryRepo.findAll();
		
	}
	
	//Get a Category By Id
	public Category getCategoryById(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
		
	}
	
//	Update a Category
	public Category UpdateCategory(Category cat,Long id) {
		Category existingCat=this.categoryRepo.findById(id).orElse(null);
		if(existingCat!=null) {
		existingCat.setId(cat.getId());
			existingCat.setName(cat.getName());
			existingCat.setProducts(cat.getProducts());
		
			
		}
		return null;
	
	}
	
	//Delete Category By Id
	public void deleteCategory(Long Id) {
		 this.categoryRepo.deleteById(Id);
		 
	}
	
	
	
}
