package web;

import java.util.ResourceBundle;

public class Properties {
	public static String URL;
	public static String usernamefiledW;
	public static String passfieldW;
	public static String usernameW;
	public static String passwordW;
	public static String signinw;
	public static String PRD;
	public static String Create_PRD;
	public static String Upload;
	public static String Select_file;
	public static String Finish_btn;
	public static String File_status;
	public static String Package;
	public static String APK_userfield;
	public static String APK_user;
	public static String APK_passfield;
	public static String APK_pass;
	public static String APK_signin;
	public static String Item_inward;
	public static String Search_field;
	public static String Article_id_field;
	public static String Confirm;
	public static String Serail_field;
	public static String GradeItem;
	public static String CheckBox1;
	public static String CheckBox2;
	public static String Next;
	public static String Missing;
	public static String None1;
	public static String Ok;
	public static String Defective;
	public static String None2;
	public static String Complete;
	public static String Proceed;
	public static String Tag_filed;
//	public static void main(String[] args) {

	public static void pro() {
		ResourceBundle rb = ResourceBundle.getBundle("Reliance");
		URL = rb.getString("url");
		usernamefiledW = rb.getString("unfieldweb");
		passfieldW = rb.getString("pwfieldweb");
		usernameW = rb.getString("usernameweb");
		passwordW = rb.getString("passwordweb");
		signinw = rb.getString("signinweb");
		PRD = rb.getString("prd");
		Create_PRD = rb.getString("create_prd");
		Upload = rb.getString("upload");
		Select_file = rb.getString("select_file");
		Finish_btn = rb.getString("finish_btn");
		File_status = rb.getString("status_file");
		Package = rb.getString("apk_pack");
		APK_userfield = rb.getString("apk_urfield");
		APK_user = rb.getString("usernameapk");
		APK_passfield = rb.getString("apk_passwordfield");
		APK_pass = rb.getString("passwordapk");
		APK_signin = rb.getString("apk_signin");
		Item_inward = rb.getString("inward");
		Search_field = rb.getString("search");
		Article_id_field = rb.getString("arti_field");
		Confirm = rb.getString("confirm");
		Serail_field = rb.getString("serail_filed");
		GradeItem = rb.getString("grade");
		CheckBox1 = rb.getString("checkbox1");
		CheckBox2 = rb.getString("checkbox2");
		Next = rb.getString("next");
		Missing = rb.getString("missing");
		None1 = rb.getString("none1");
		Ok = rb.getString("ok");
		Defective = rb.getString("defective");
		None2 = rb.getString("none1");
		Complete = rb.getString("complete");
		Proceed = rb.getString("proceed");
		Tag_filed = rb.getString("tag_filed");
	}
}
