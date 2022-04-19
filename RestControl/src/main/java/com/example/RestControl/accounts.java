package com.example.RestControl;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.json.simple.JSONObject;
// Test


public class accounts {
	private final String uid;
	private String name;
	private JSONObject address_JSON;
	private String street;
	private String zip;

	private String phone;
	private String picture;
	private boolean is_active;
	private String formatted_date;

    



    public accounts(String uid, String name, String street, String zip, String phone, String picture, boolean is_active, String formatted_date) {
		this.uid = uid;
		this.name = name;
        this.address_JSON = new JSONObject();
	    address_JSON.put(street, zip);
		this.address.put(address_JSON);
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
	public Dictionary getAddress() {
		return address;
	}
    /*
    public String getStreet() {
        return street;
    }
    public String getZip() {
        return zip;
    }*/
    public String getPhone() {
        return phone;
    }
    public String getPicture() {
        return picture;
    }
    public boolean getIs_active() {
        return is_active;
    }
    public String getformatted_date() {
        return formatted_date;
    }
}

