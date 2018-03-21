package mytranslator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mytranslator.model.Text;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {

		System.out.println("calling index controller.");

		Text text = new Text();

		model.addAttribute(text);

		return "index";
	}
}
