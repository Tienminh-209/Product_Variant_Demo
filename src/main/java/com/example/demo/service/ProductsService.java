package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public interface ProductsService {
	 Product saveproduct(Product product );
	 String deleteProduct(long id);
	 Product updateProduct(Product product,long id );
}
