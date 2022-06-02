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
@Table(name = "product_variants_values")
public class ProductVariantsValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	// many to one productVariantsValues vs ProductVariantsOptions
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_variant_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ProductVariantsOptions variantsOptions;

	// manytomany ProductVariantsOptions vs skus
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_variant_value_combinations", joinColumns = @JoinColumn(name = "product_variant_value_id"), inverseJoinColumns = @JoinColumn(name = "sku_id"))
	Set<Skus> skus = new HashSet<Skus>();

	public ProductVariantsValue() {
	}

	public ProductVariantsValue(Long id, String name) {
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

	public ProductVariantsOptions getVariantsOptions() {
		return variantsOptions;
	}

	public void setVariantsOptions(ProductVariantsOptions variantsOptions) {
		this.variantsOptions = variantsOptions;
	}

	public Set<Skus> getSkus() {
		return skus;
	}

	public void setSkus(Set<Skus> skus) {
		this.skus = skus;
	}

}
