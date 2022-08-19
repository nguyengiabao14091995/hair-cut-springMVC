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

import net.javaguides.springboot.model.AskPrice;
import net.javaguides.springboot.service.AskPriceService;

@Controller
public class AskPriceController {
	@Autowired
	private AskPriceService service;

	@RequestMapping("/ask-price-tables")
	public String viewBookingPage(Model model) {
		List<AskPrice> listAskPrice = service.listAll();
		model.addAttribute("listAskPrice", listAskPrice);
		return "askPriceTable";
	}

	@RequestMapping("/ask-price-new")
	public String showNewAskPricePage(Model model) {
		AskPrice askPrice = new AskPrice();
		model.addAttribute("askPrice", askPrice);
		return "addAskPrice";
	}
	
	@RequestMapping(value = "/saveAskPrice", method = RequestMethod.POST)
	public String saveAskPrice(@ModelAttribute("askPrice") AskPrice askPrice) {
		service.save(askPrice);
		return "redirect:ask-price-tables";
	}
	
	@RequestMapping("/editAskPrice/{id}")
	public ModelAndView showEditAskPricePage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("editAskPrice");
		AskPrice askPrice = service.get(id);
		service.delete(id);
		mav.addObject("askPrice",askPrice);
		return mav;
	}
	
	@RequestMapping("/deleteAskPrice/{id}")
	public String deleteAskPrice(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/ask-price-tables";
	}

}
