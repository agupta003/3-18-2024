package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;

@Controller
public class ContactControler {
	@ModelAttribute
	public void commonDataModel(Model m) {
		m.addAttribute("Header", "Learn Spring MVC");
		m.addAttribute("Desc", "Spring MVC Conference");
		System.out.println("Adding Common tags");
	}

	@RequestMapping("/contact")
	public String showForm(Model m) {
		System.out.println("Showing the form : Latest Spring way of handeling model and view");
		/*
		 * m.addAttribute("Header", "Learn Spring MVC"); m.addAttribute("Desc",
		 * "Spring MVC Conference");
		 */
		return "contact";
	}

	@RequestMapping("/old_contact")
	public String showForm1() {
		System.out.println("Showing the form : Old Method showForm1 is called");

		return "old_way_contact";
	}
	
	/*/// Old Way of getting values from view 
	 * @RequestMapping(path="/processform", method=RequestMethod.POST) public String
	 * handlerForm(HttpServletRequest request) { 
	 * String email = request.getParameter("email"); 
	 * return "processform"; }
	 */

	
	  @RequestMapping(path="/processform1", method=RequestMethod.POST) public
	  String handlerForm(	  
			  @RequestParam(name= "email", required = true) String userEmail,
			  @RequestParam("userName") String userName,
			  @RequestParam("password") String userPassword, Model model) 
	  { User user = new
	  User(); user.setUserName(userName); 
	  user.setEmail(userEmail);
	  user.setPassword(userPassword); 
	  
	  model.addAttribute("user", user);
	  model.addAttribute("email", userEmail); 
	  model.addAttribute("password", userPassword); 
	  model.addAttribute("userName", userName);
	  System.out.println("User of old processform1 :-"+user); 
	  return "success"; 
	  }
	 

	@RequestMapping(path="/processform", method=RequestMethod.POST)
	public String handlerForm(@ModelAttribute User user, Model model) 
	{
		/*
		 * model.addAttribute("Header", "Learn Spring MVC"); model.addAttribute("Desc",
		 * "Spring MVC Conference");
		 */
		model.addAttribute("user", user);
		
		System.out.println(user);
		return "success";
	}
}
