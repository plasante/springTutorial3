package com.uniksoft.domain;

import java.io.Serializable;
import java.util.List;

public interface ProductManager extends Serializable {
	public void increasePrice(int percentage);
	public List<Product> getProducts();
}
