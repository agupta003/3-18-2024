package mvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/home")
	public String search() {
		System.out.println ("going to home view");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView  search(@RequestParam("querybox") String query) throws IOException {
		String url = "https://www.google.com/search?q="+query;
		RedirectView rv = new RedirectView();
		rv.setUrl(url);
		return rv;
	}
	
	@RequestMapping("/complex")
	public String showForm() {
		System.out.println ("Show Form");
		return "complex_form";
	}
	
	// Not appropriate way of using [@RequestParam("name") String name, @RequestParam("id") Long id] in method arguments
	  @RequestMapping(path="/handleform1", method=RequestMethod.POST) 
	  public String complexformHandler(@RequestParam("name") String name, @RequestParam("id") Long id) {
	  System.out.println(name); System.out.println(id); 
	  return "sucess"; 
	  }
	  
	  
	 // appropriate way 
	 // Auto-binding [@ModelAttribute("student") Student student] 
	  
	@RequestMapping(path="/handleform", method=RequestMethod.POST)
	public String formHandler(@ModelAttribute("student") Student student, BindingResult result){
		
		if(result.hasErrors()){
			return "complex_form";
		}
		System.out.println(student);
		System.out.println(student.getAddress());
		return "success2";
	}

}
