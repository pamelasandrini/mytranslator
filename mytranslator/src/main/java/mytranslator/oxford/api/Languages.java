package mytranslator.oxford.api;

import mytranslator.properties.PropertiesUtil;

public class Languages {

	private String language;
	private String targetLanguage;
	private PropertiesUtil prop = new PropertiesUtil();

	{
		language = prop.getValue("language");
		targetLanguage = prop.getValue("target_language");
		System.out.println(this);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public String toString() {
		return "language : " + language + " target language : " + targetLanguage;
	}

}
