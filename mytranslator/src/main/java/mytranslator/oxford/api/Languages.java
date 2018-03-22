package mytranslator.oxford.api;

public class Languages {

	private String language;
	private String targetLanguage;

	{
		// TODO: get it from config file
		language = "en";
		targetLanguage = "pt";
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
