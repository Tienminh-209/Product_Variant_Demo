package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	private ProductsService productsService;

	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productsService.saveproduct(product);
	}

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable long id) {
		return productsService.updateProduct(product, id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable long id) {
		return productsService.deleteProduct(id);
	}
}