package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class FileUploadControler {

		@RequestMapping("/fileform")
	public String showUploadForm() {
		
		return "fileForm";
	}
	@RequestMapping(path="/uploadimage", method=RequestMethod.POST)
		//public String fileUpload(@RequestPart("file") MultipartFile multipartFile) {
	public String fileUpload() {
		System.out.println("File upload handeler");
		
			return "success";
		}
}
