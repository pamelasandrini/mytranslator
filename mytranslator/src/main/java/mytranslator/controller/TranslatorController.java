package mytranslator.controller;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mytranslator.model.Text;
import mytranslator.oxford.api.ApiCaller;

@Controller
public class TranslatorController {

	@RequestMapping(value = "/translate", method = RequestMethod.GET)
	public String sampleNameRestController(@ModelAttribute("text") Text text, Model model) {
		System.out.println("calling translate method");
		System.out.println("Received text: " + text.getOriginalText());

		if (null == text.getOriginalText() || text.getOriginalText().isEmpty()) {
			return "invalid text";
		}

		ApiCaller apiCaller = new ApiCaller(text.getOriginalText());
		text.setTranslatedText(apiCaller.callApi());

		return MessageFormat.format("Translated text: {0}", text.getTranslatedText());
	}

}
