package com.uniksoft.repository;

import java.util.List;

import com.uniksoft.domain.Product;

public interface ProductDao {
	public List<Product> getProductList();
	public void saveProduct(Product prod);
}
