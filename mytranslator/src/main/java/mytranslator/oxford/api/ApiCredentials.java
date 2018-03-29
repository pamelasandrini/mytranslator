package mytranslator.oxford.api;

public class ApiCredentials {

	private String app_id;
	private String app_key;

	{
		// TODO: get it from config file
		app_id = "266b0234";
		app_key = "0c20f7358c9448b782925dde41f76242";

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
		return "app_id : " + app_id + " app_key : " + app_key;
	}

}
