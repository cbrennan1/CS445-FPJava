package com.example.RestControl;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.json.simple.JSONObject;
import java.util.Map;
import java.util.LinkedHashMap;
// Test


public class Accounts {
	private final String uid;
	private String name;
	private Map address = new LinkedHashMap(2);

	private String phone;
	private String picture;
	private boolean is_active;
	private String formatted_date;
	
	public Accounts(String uid, String name, Map address, String phone, String picture, boolean is_active, String formatted_date) {
		this.uid = uid;
		this.name = name;
		this.address = address; 
		this.phone = phone;
		this.picture = picture;
		this.is_active = is_active;
		this.formatted_date = formatted_date;
	}

	


	public String getUid() {
		return uid;
	}
	public String getName() {
		return name;
	}
	public Map getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	public String getPicture() {
		return picture;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public String getFormatted_Date() {
		return formatted_date;
	}
	
}
