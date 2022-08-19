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

import net.javaguides.springboot.model.SampleHair;
import net.javaguides.springboot.service.SampleHairService;

@Controller
public class SampleHairController {
	@Autowired
	private SampleHairService service;
	
	@RequestMapping("/sample-hair")
	public String viewSampleHairPage(Model model) {
		List<SampleHair> listSampleHair = service.listAll();
		model.addAttribute("listSampleHair", listSampleHair);
		return "sampleHair";
	}
	
	@RequestMapping("/sample-hair-top-view")
	public String viewSampleHairTopViewPage(Model model) {
		List<SampleHair> listSampleHairTop = service.findByTop();
		model.addAttribute("listSampleHairTop", listSampleHairTop);
		return "statisticHair";
	}
	
	@RequestMapping("/sample-hair-tables")
	public String viewSampleHairTablesPage(Model model) {
		List<SampleHair> listSampleHairTables = service.listAll();
		model.addAttribute("listSampleHairTables", listSampleHairTables);
		return "sampleHairTables";
	}

	@RequestMapping("/sample-hair-new")
	public String showNewSampleHairPage(Model model) {
		SampleHair sampleHair = new SampleHair();
		model.addAttribute("sampleHair", sampleHair);
		return "addSampleHair";
	}

	@RequestMapping(value = "/saveSampleHair", method = RequestMethod.POST)
	public String saveSampleHair(@ModelAttribute("sampleHair") SampleHair sampleHair) {
		service.save(sampleHair);
		return "redirect:sample-hair-tables";
	}
	
	@RequestMapping("/editSampleHair/{id}")
	public ModelAndView showEditSampleHairPage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("editSampleHair");
		SampleHair sampleHair = service.get(id);
		service.delete(id);
		mav.addObject("sampleHair",sampleHair);
		return mav;
	}
	
	@RequestMapping("/deleteSampleHair/{id}")
	public String deleteSampleHair(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:sample-hair-tables";
	}	
	
	@RequestMapping("/showSampleHairDetail/{id}")
	public ModelAndView showSampleHairDetailPage(@PathVariable(name = "id") long id) {
	    ModelAndView mav = new ModelAndView("sampleHairSingle"); 
	    SampleHair sampleHair = service.get(id);
	    int count = sampleHair.getCountView();
		count = count + 1;
		sampleHair.setCountView(count);
		service.save(sampleHair);
	    mav.addObject("sampleHair", sampleHair);
	    return mav;
	}
}
