package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Product;

public interface ProductService {
	public int add(Product p);
	public int remove(int id);
	public List<Product> getAll();
	

}
