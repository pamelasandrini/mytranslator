package mytranslator.oxford.api;

import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

		String translation;
		try {
			URL url = new URL(buildUrl());
			HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
			request.setRequestProperty("Accept", "application/json");
			request.setRequestProperty("app_id", credentials.getApp_id());
			request.setRequestProperty("app_key", credentials.getApp_key());

			request.connect();

			// Convert to a JSON object
			JsonParser jp = new JsonParser();
			JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));

			// reading the response
			JsonObject response = root.getAsJsonObject();
			JsonObject resultsObject = response.getAsJsonArray("results").get(0).getAsJsonObject();
			System.out.println("result: " + resultsObject);

			JsonObject lexicalEntriesObject = resultsObject.getAsJsonArray("lexicalEntries").get(0).getAsJsonObject();

			JsonObject entriesObject = lexicalEntriesObject.getAsJsonArray("entries").get(0).getAsJsonObject();

			JsonObject sensesObject = entriesObject.getAsJsonArray("senses").get(0).getAsJsonObject();

			JsonObject translationsObject = sensesObject.getAsJsonArray("translations").get(0).getAsJsonObject();

			translation = translationsObject.get("text").getAsString();

			System.out.println(translation);

			return translation;

		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}

	private String buildUrl() {

		String url = API_URL + languages.getLanguage() + "/" + word + "/translations=" + languages.getTargetLanguage();
		System.out.println("url " + url);
		return url;
	}

}
