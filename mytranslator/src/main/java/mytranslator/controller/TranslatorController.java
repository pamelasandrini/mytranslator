package mytranslator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mytranslator.concurrency.ParallelApiCall;
import mytranslator.model.Text;

@Controller
public class TranslatorController {

	@RequestMapping(value = "/translate", method = RequestMethod.GET)
	public String sampleNameRestController(@ModelAttribute("text") Text text, Model model) throws Exception {
		System.out.println("calling translate method");
		System.out.println("Received text: " + text.getOriginalText());

		if (null == text.getOriginalText() || text.getOriginalText().isEmpty()) {
			return "invalid text";
		}

		List<String> callableList = new ArrayList<>();
		callableList.add(text.getOriginalText());

		getWordsFromString(text.getOriginalText()).stream().forEach(w -> callableList.add(w));

		ParallelApiCall parallelCall = new ParallelApiCall(callableList);
		List<String> responseList = parallelCall.performApiCalls();

		text.setTranslatedText(buildStringFromWords(responseList));
		
		return "index";
		
	}

	private List<String> getWordsFromString(String text) {

		List<String> wordList = new ArrayList<>();
		if (text != null && !text.isEmpty()) {

			String regex = "\\s";
			wordList = Arrays.asList(text.split(regex));
		}

		return wordList;
	}

	private String buildStringFromWords(List<String> wordList) {
		StringBuilder string = new StringBuilder();

		if (wordList != null) {
			wordList.stream().forEach(w -> string.append(w + " "));
		}

		return string.toString();
	}

}
