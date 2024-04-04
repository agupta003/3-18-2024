package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProclicksController {

	@RequestMapping("/proclicksHome")	
	public String proclicksHome() {
		System.out.println("This Procklicks home url");
		return "proclicksHome";
	}
	
	@RequestMapping("/aboutUs")
	public String aboutUs() {
		System.out.println("This is Proclicks about us url");
		return "aboutUs";
	}
}
