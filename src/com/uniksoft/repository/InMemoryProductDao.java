package com.uniksoft.repository;

import java.util.List;

import com.uniksoft.domain.Product;

public class InMemoryProductDao implements ProductDao {

	private List<Product> productList;
	
	public InMemoryProductDao(List<Product> productList) {
		this.productList = productList;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void saveProduct(Product prod) {
		
	}

}
