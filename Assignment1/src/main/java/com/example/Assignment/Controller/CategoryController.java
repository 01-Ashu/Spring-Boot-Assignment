package com.example.Assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment.Entity.Category;
import com.example.Assignment.Services.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get All Categories
    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    // Get Single Category By Id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    // Create A Category
    @PostMapping
    public Category createCategory(@RequestBody Category cat) {
        return this.categoryService.CreateRepository(cat);
    }

    // Update a Category
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category cat, @PathVariable Long id) {
        return this.categoryService.UpdateCategory(cat, id);
    }

    // Delete a Category
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
    }
}
