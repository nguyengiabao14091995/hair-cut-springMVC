package net.javaguides.springboot.service;

import java.util.Collection;

import net.javaguides.springboot.model.CartItem;

public interface ShopingCartService {
	
	
	public void add(CartItem item);
	
	public void remove(long id);

	public CartItem update(long productId, int quantity);
	
	public void clear();
	
	public Collection<CartItem> getAllItem();
	
	public int getCount();
	
	public double getAmount();
}
