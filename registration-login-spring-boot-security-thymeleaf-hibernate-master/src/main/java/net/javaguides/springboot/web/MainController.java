package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.ServiceHair;
import net.javaguides.springboot.service.ServiceHairService;

@Controller
public class MainController {
	@Autowired
	private ServiceHairService service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/thanks-booking")
	public String ThanhksBooking() {
		return "thanksBooking";
	}
	
	@GetMapping("/404")
	public String Page404() {
		return "404";
	}

	@GetMapping("/")
	public String index(Model model) {
		List<ServiceHair> listServiceHair= service.listAll();
		model.addAttribute("listServiceHair", listServiceHair);
		return "index";
	}
	
	@GetMapping("/edit-profile-user")
	public String editProfileUser() {
		return "editProfileUser";
	}

	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}

	@RequestMapping("/home")
	public String showHomePage(Model model) {
		List<ServiceHair> listServiceHair= service.listAll();
		model.addAttribute("listServiceHair", listServiceHair);
		return "home";
		}
	
	
	@RequestMapping("/booking-service-hair/{id}")
	public String showBookingServiceHairPage(@PathVariable(name="id")long id) {
		ServiceHair serviceHair = service.get(id);
		int count = serviceHair.getCountService();
		count = count + 1;
		serviceHair.setCountService(count);
		service.save(serviceHair);
		return "bookingServiceHairSuccess";
	}
		
	@GetMapping("/thanks")
	public String thanks() {
		return "thanks";
	}
	

	@GetMapping("/booking")
	public String booking() {
		return "booking";
	}

	@GetMapping("/booking-home")
	public String bookingHome() {
		return "bookingHome";
	}

	@GetMapping("/shop-single")
	public String shopSingle() {
		return "shopSingle";
	}

	@GetMapping("/admin-table")
	public String adminTables() {
		return "adminTables";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/ask-success")
	public String askSuccess() {
		return "askPriceSuccess";
	}
	
}
