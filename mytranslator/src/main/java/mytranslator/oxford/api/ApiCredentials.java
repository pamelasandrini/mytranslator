package mytranslator.oxford.api;

import mytranslator.properties.PropertiesUtil;

public class ApiCredentials {

	private String app_id;
	private String app_key;
	private PropertiesUtil prop = new PropertiesUtil();

	{
		app_id = prop.getValue("app_id");
		app_key = prop.getValue("app_key");

		System.out.println(this);
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String toString() {
		return "ApiCredentials \n app_id : " + app_id + " app_key : " + app_key;
	}

}
