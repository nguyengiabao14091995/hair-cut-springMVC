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
import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.ServiceHair;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.service.ServiceHairService;

@Controller
public class BookingController {
	@Autowired
	private BookingService service;
	
	@Autowired
	private ServiceHairService service2;

	@RequestMapping("/booking-tables")
	public String viewBookingPage(Model model) {
		List<Booking> listBooking = service.listAll();
		model.addAttribute("listBooking", listBooking);
		return "bookingTable";
	}

	@RequestMapping("booking-new")
	public String showNewBookingPage(Model model) {
		List<ServiceHair> listServiceHair = service2.listAll();
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		model.addAttribute("listServiceHair ", listServiceHair);
		return "booking";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBooking(@ModelAttribute("booking") Booking booking) {
		service.save(booking);
		return "redirect:/thanks-booking";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditBookingPage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("bookingEdit");
		Booking booking = service.get(id);
		service.delete(id);
		mav.addObject("booking",booking);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBooking(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/booking-tables";
	}
}
