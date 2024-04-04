package mvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RedirectController {
	
	@RequestMapping("/one")
	public String  oneUrl() {
		System.out.println("This is first url");
		return "redirect:/error";
	}
	
	@RequestMapping("/error")
	public String  twoUrl() {
		System.out.println("This is second url");
		return "";
	}
	
	@RequestMapping("/1")
	public RedirectView  url1() {
		System.out.println("This is 1 url");
		RedirectView rv = new RedirectView();
		rv.setUrl("2");
		return rv;
	}
	
	@RequestMapping("/2")
	public String  url2() {
		System.out.println("This is 2 url");
		return "";
	}
	
	@RequestMapping("/3")
	public String  url3(HttpServletResponse res) throws IOException {
		System.out.println("This is 3 url");
		res.sendRedirect("error");
		return "";
	}
	
	
	
}
