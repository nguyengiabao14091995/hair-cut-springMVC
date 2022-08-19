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

import net.javaguides.springboot.model.BookingHome;
import net.javaguides.springboot.service.BookingHomeService;

@Controller
public class BookingHomeController {
	@Autowired
	private BookingHomeService service;

	@RequestMapping("/booking-home-table")
	public String viewBookingHomePage(Model model) {
		List<BookingHome> listBookingHome = service.listAll();
		model.addAttribute("listBookingHome", listBookingHome);
		return "bookingHomeTable";
	}
	
	@RequestMapping("booking-home-new")
	public String showNewBookingHomePage(Model model) {
		BookingHome bookingHome = new BookingHome();
		model.addAttribute("bookingHome", bookingHome);
		return "bookingHome";
	}
	
	@RequestMapping(value = "/saveBookingHome", method = RequestMethod.POST)
	public String saveBookingHome(@ModelAttribute("bookingHome") BookingHome bookingHome) {
		service.save(bookingHome);
		return "redirect:/thanks-booking";
	}
	
	@RequestMapping("/editBookingHome/{id}")
	public ModelAndView showEditBookingPage(@PathVariable(name="id") long id) {
		ModelAndView mav = new ModelAndView("bookingHomeEdit");
		BookingHome bookingHome = service.get(id);
		service.delete(id);
		mav.addObject("bookingHome", bookingHome);
		return mav;
	}
	
	@RequestMapping("/deleteBookingHome/{id}")
	public String deleteBookingHome(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/booking-home-table";
	}

}
