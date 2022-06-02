package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "skus")
public class Skus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "sku")
	private String sku;

	@Column(name = "price")
	private double price;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product products;

	// manytomany skus vs ProductVariantsOptions
	@ManyToMany(mappedBy = "skus", fetch = FetchType.LAZY)
	Set<ProductVariantsValue> variantsValues = new HashSet<ProductVariantsValue>();

	public Skus() {
		super();
	}

	public Skus(String sku, double price, Product products, Set<ProductVariantsValue> variantsValues) {
		super();
		this.sku = sku;
		this.price = price;
		this.products = products;
		this.variantsValues = variantsValues;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Set<ProductVariantsValue> getVariantsValues() {
		return variantsValues;
	}

	public void setVariantsValues(Set<ProductVariantsValue> variantsValues) {
		this.variantsValues = variantsValues;
	}

}
