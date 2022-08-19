package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService service;

	@RequestMapping("/role-tables")
	public String viewRolePage(Model model) {
		List<Role> listRole = service.listAll();
		model.addAttribute("listRole", listRole);
		return "roleTables";
	}

	@RequestMapping("/role-new")
	public String showRolePage(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		return "addRoleTable";
	}
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public String saveRole(@ModelAttribute("role") Role role) {
		service.save(role);
		return "redirect:role-tables";
	}
	
	@GetMapping("/editRole/{id}")
	public ModelAndView showEditRolePage(@PathVariable(name="id")long id) {
		ModelAndView mav = new ModelAndView("editRole");
		Role role = service.get(id);
		service.delete(id);
		mav.addObject("role",role);
		return mav;
	}
	
	@RequestMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/role-tables";
	}

}
