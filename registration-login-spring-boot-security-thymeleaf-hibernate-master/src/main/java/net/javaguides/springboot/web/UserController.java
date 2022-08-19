package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.RoleService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
@Controller
public class UserController {
	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/users-tables")
	public String viewUserTablePage(Model model) {
		List<User> listUser = service.listAll();
		model.addAttribute("listUser", listUser);
		return "userTables";
	}
	
	@PostMapping("user-table-new")
	public String showUserTableNewPage(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "/addUserTable";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		return "/";
	}
	
	@RequestMapping(value = "/saveUserTable", method = RequestMethod.POST)
	public String saveUserTable(@ModelAttribute("user") User user) {
		service.save(user);
		return "redirect:/users-tables";
	}
	
	@RequestMapping("/edit-user-table/{id}")
	public ModelAndView showEditUserTablePage(@PathVariable(name="id")long id, Model model) {
		ModelAndView mav = new ModelAndView("editUserTable");
		List<Role> listRole = roleService.listAll();
		User user = service.get(id);
		service.delete(id);
		model.addAttribute("user", user);
	    model.addAttribute("listRole", listRole);
		return mav;
	}
	
	@RequestMapping("/edit-user")
	public ModelAndView showEditUserPage() {
		ModelAndView mav = new ModelAndView("editProfileUser");
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String username = authentication.getName();
		User user = service.getName(username);
		service.delete(user.getId());
		mav.addObject("user",user);
		return mav;
	}
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(name ="id")long id) {
		service.delete(id);
		return "redirect:/booking-tables";
	}

}
