package mytranslator.oxford.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiCaller {

	// TODO: get it from config file
	private final String API_URL = "https://od-api.oxforddictionaries.com:443/api/v1/entries/";

	private ApiCredentials credentials;
	private Languages languages;
	private String word;

	public ApiCaller(String word) {
		super();
		this.word = word.toLowerCase();
		languages = new Languages();
		credentials = new ApiCredentials();
	}

	public String callApi() {
		// do something

		try {
			URL url = new URL(buildUrl());
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestProperty("app_id", credentials.getApp_id());
			urlConnection.setRequestProperty("app_key", credentials.getApp_key());

			// read the output from the server
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();

			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}

			return stringBuilder.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

		// return "translation";
	}

	private String buildUrl() {

		String url = API_URL + languages.getLanguage() + "/" + word + "/translations=" + languages.getTargetLanguage();
		System.out.println("url " + url);
		return url;
	}

}
