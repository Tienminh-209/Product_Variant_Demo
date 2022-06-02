package com.example.demo.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
@Transactional
public class ProductsDAO {

	@Autowired
	private SessionFactory factory;

//saveProduct
	@SuppressWarnings("deprecation")
	public Product saveProduct(Product product) {
		Session session = factory.getCurrentSession();
		Product newproduct = new Product();
		session.save(product);
		return product;
	}

	// deleteProduct
	@SuppressWarnings("deprecation")
	public String deleteProduct(long id) {
		Session session = factory.getCurrentSession();
		Product newproduct = session.get(Product.class, id);
		session.delete(newproduct);
		return "Delete product successly";
	}
	// updateProduct
	@SuppressWarnings("deprecation")
	public Product updateProduct(Product product,long id) {
		Session session = factory.getCurrentSession();
		Product newproduct = session.get(Product.class, id);
		newproduct.setName(product.getName());
		session.save(newproduct);
		return newproduct;
	}
}
