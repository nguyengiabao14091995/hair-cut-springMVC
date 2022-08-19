package net.javaguides.springboot.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.CartItem;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.service.ProductServiceImpl;
import net.javaguides.springboot.service.ShopingCartService;

@Controller
public class ShoppingCartController {


	@Autowired
	private ShopingCartService shopingCartService;

	@Autowired
	private ProductServiceImpl proService;

	@RequestMapping("/shopping-cart")
	public String viewProductPage(Model model) {
		Collection<CartItem> listCartItem = shopingCartService.getAllItem();
		model.addAttribute("listCartItem", listCartItem);
		model.addAttribute("total", shopingCartService.getAmount());
		return "shoppingCart";
	}

	@RequestMapping("/addCart/{id}")
	public String addCart(@PathVariable(name = "id") int id) {
		
		Product product = proService.get(id);
		System.out.println(product.getName());
		
		if (product != null) {
			CartItem cartItem = new CartItem();
			cartItem.setProductId(product.getId());
			cartItem.setName(product.getName());
			cartItem.setPrice(product.getPrice());
			cartItem.setQuantity(1);
			cartItem.setImage(product.getImage());
			shopingCartService.add(cartItem);
		}
		return "redirect:/product-shop";

	}
	
	@RequestMapping("/deleteCart/{id}")
	public String removeCart(@PathVariable(name = "id") long id) {
		shopingCartService.remove(id);
		return "redirect:/shopping-cart";
	}
	
	@RequestMapping("/deleteAll")
	public String removeAllCart() {
		shopingCartService.clear();
		return "redirect:/shopping-cart";
	}

}
