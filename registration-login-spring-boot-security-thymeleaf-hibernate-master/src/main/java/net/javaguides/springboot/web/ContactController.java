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

import net.javaguides.springboot.model.Contact;
import net.javaguides.springboot.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService service;
	
	@RequestMapping("/contact-tables")
	public String viewBookingPage(Model model) {
		List<Contact> listContact = service.listAll();
		model.addAttribute("listContact", listContact);
		return "ContactTable";
	}
	
	@RequestMapping("contact")
	public String showNewBookingPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		service.save(contact);
		return "redirect:thanks";
	}
	
	@RequestMapping("/editContact/{id}")
	public ModelAndView showEditContactPage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("contactEdit");
		Contact contact = service.get(id);
		service.delete(id);
		mav.addObject("contact",contact);
		return mav;
	}
	
	@RequestMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/booking-table";
	}
}
