package com.example.Assignment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment.Entity.Category; // Correct import
import com.example.Assignment.Entity.Product;
import com.example.Assignment.Repository.CategoryRepository;
import com.example.Assignment.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public Product createProduct(Product product, Long categoryId) {
        // Fetch the category by ID
        Category category = categoryRepo.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        // Set the category to the product
        product.setCategory(category);

        // Save the product
        return productRepo.save(product);
    }
	//Get Product By Id
	public Product GetProduct(Long Id) {
		return this.productRepo.findById(Id).orElse(null);
		
	}
	//Get All Product
	public List<Product> GetAllProduct(){
		return this.productRepo.findAll();
	}
	//Update 
	public Product UpdateProduct(Product prd,Long Id) {
		Product existingProd=this.productRepo.findById(Id).orElse(null);
		if(existingProd!=null) {
			existingProd.setId(prd.getId());
			existingProd.setName(prd.getName());
			existingProd.setPrice(prd.getPrice());
			existingProd.setCategory(prd.getCategory());
			return existingProd;
			
		}
		
		return null;
	}
	//Delete
	public void DeleteProduct(Long Id) {
		this.productRepo.deleteById(Id);
	}
	
}
