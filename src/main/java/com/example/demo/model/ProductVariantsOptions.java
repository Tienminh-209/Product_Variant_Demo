package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_variants_options")
public class ProductVariantsOptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;

	public ProductVariantsOptions() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "variantsOptions",cascade = CascadeType.ALL)
	Set<ProductVariantsValue> productVariantsValues = new HashSet<ProductVariantsValue>();

	public ProductVariantsOptions(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<ProductVariantsValue> getProductVariantsValues() {
		return productVariantsValues;
	}

	public void setProductVariantsValues(Set<ProductVariantsValue> productVariantsValues) {
		this.productVariantsValues = productVariantsValues;
	}

}
