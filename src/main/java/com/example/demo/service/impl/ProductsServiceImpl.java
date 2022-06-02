package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductsDAO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;
@Service
public class ProductsServiceImpl implements ProductsService {
//save Product
	@Autowired 
	private ProductsDAO productsDAO;
	
	public Product saveproduct(Product product ) {
		return productsDAO.saveProduct(product);
		
	}
	@Override
	public String deleteProduct(long id) {
		return productsDAO.deleteProduct(id);
		
	}
	@Override
	public Product updateProduct(Product product, long id) {
		return productsDAO.updateProduct(product, id);
	}
}
