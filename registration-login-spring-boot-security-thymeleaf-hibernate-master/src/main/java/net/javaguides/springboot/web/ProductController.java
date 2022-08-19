package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.service.ProductServiceImpl;
@Controller
public class ProductController {
	
	@Autowired
    private ProductServiceImpl service;

	@RequestMapping("/product-tables")
	public String viewProductPage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);	     
	    return "productTable";
	}
	
	@RequestMapping("/product-shop")
	public String viewProductShopPage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);	     
	    return "shop";
	}
	
	@RequestMapping("/new-products")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);     
	    return "addProduct";
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {          
	    service.save(product);	     
	    return "redirect:product-tables";
	}
	
	@RequestMapping("/editProduct/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("productEdit");
	    Product product = service.get(id);
	    service.delete(id);
	    mav.addObject("product", product);
	    return mav;
	}
	
	@RequestMapping("/showProductDetail/{id}")
	public ModelAndView showProductDetailPage(@PathVariable(name = "id") long id) {
	    ModelAndView mav = new ModelAndView("shopSingle"); 
	    Product product = service.get(id);
	    mav.addObject("product", product);
	    return mav;
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/product-tables";       
	}
}
