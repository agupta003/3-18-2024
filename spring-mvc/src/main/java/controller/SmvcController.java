package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/FirstController")
public class SmvcController {

	//@RequestMapping("/proclicksHome")
	@RequestMapping(path="/proclicksHome", method = RequestMethod.GET)
	public String proclickshome(Model model) {
		model.addAttribute("name", "Benu Gupta");
		model.addAttribute("id", 1212);
		
		
		
		List<String> fiends = new ArrayList<String>();
		fiends.add("Kapil");
		fiends.add("Manish");
		fiends.add("Mahesh");
		
		model.addAttribute("friends",fiends);
		
		return "proclicksHome";
	}
	@RequestMapping("/aboutus")
	public String aboutUs() {
		System.out.println("AboutUs logs");
		return "aboutUs";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		
		ModelAndView mnv=new ModelAndView();
		mnv.addObject("name","Abhishek Gupta");
		mnv.addObject("age",47);
		
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(12342);
		list.add(1223);
		list.add(122);
		
		// this mnv object has booth the things -> object values and view name
		mnv.addObject("marks", list);
		mnv.setViewName("help");
		
		return mnv;
	}
}
