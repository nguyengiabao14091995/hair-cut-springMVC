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

import net.javaguides.springboot.model.ServiceHair;
import net.javaguides.springboot.service.ServiceHairService;

@Controller
public class ServiceHairController {
	@Autowired
	private ServiceHairService service;

	@RequestMapping("/service-hair-tables")
	public String viewBookingPage(Model model) {
		List<ServiceHair> listServiceHair = service.listAll();
		model.addAttribute("listServiceHair", listServiceHair);
		return "ServiceHairTable";
	}
	
	@RequestMapping("/service-hair-top-view")
	public String viewServiceHairTopViewPage(Model model) {
		List<ServiceHair> listSampServiceHairTop = service.findByTop();
		model.addAttribute("listSampServiceHairTop", listSampServiceHairTop);
		return "statisticService";
	}

	@RequestMapping("/service-hair-new")
	public String showNewBookingPage(Model model) {
		ServiceHair serviceHair = new ServiceHair();
		model.addAttribute("serviceHair", serviceHair);
		return "addServiceHair";
	}

	@RequestMapping(value = "/saveServiceHair", method = RequestMethod.POST)
	public String saveServiceHair(@ModelAttribute("editServiceHair") ServiceHair serviceHair) {
		service.save(serviceHair);
		return "redirect:service-hair-tables";
	}
	
	@RequestMapping("/editServiceHair/{id}")
	public ModelAndView showEditServiceHairPage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("editServiceHair");
		ServiceHair serviceHair = service.get(id);
		service.delete(id);
		mav.addObject("serviceHair",serviceHair);
		return mav;
	}
	
	@RequestMapping("/deleteServiceHair/{id}")
	public String deleteServiceHair(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/service-hair-tables";
	}
}
