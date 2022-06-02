package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<Skus> skus = new HashSet<Skus>();

	@OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Set<ProductVariantsOptions> productVariantsOptions = new HashSet<ProductVariantsOptions>();

	public Product() {
		super();
	}

	public Product(String name, Set<Skus> skus, Set<ProductVariantsOptions> productVariantsOptions) {
		super();

		this.name = name;
		this.skus = skus;
		this.productVariantsOptions = productVariantsOptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Skus> getSkus() {
		return skus;
	}

	public void setSkus(Set<Skus> skus) {
		this.skus = skus;
	}

	public Set<ProductVariantsOptions> getProductVariantsOptions() {
		return productVariantsOptions;
	}

	public void setProductVariantsOptions(Set<ProductVariantsOptions> productVariantsOptions) {
		this.productVariantsOptions = productVariantsOptions;
	}

}
