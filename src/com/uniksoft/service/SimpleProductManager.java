package com.uniksoft.service;

import java.util.List;

import com.uniksoft.domain.Product;
import com.uniksoft.domain.ProductManager;
import com.uniksoft.repository.ProductDao;

public class SimpleProductManager implements ProductManager {

	private ProductDao productDao;
	
	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for(Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage)/100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}

	public List<Product> getProducts() {
		return productDao.getProductList();
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
