package com.example.RestControl;
import java.util.Date;
import java.util.Calendar;

// Test


public class accounts {
    private String uid;
    private String name;
    private Object address;
    private String street;
    private int zip;
    private String phone;
    private String picture;
    private boolean is_active;
  //private Date date_created;
    private String formatted_date;
    //private String message;


    public accounts() {

    }

    public accounts(String uid, String name, Object address, String phone, String picture, boolean is_active, String formatted_date) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        //this.street = street;
        //this.zip = zip;
        this.phone = phone;
        this.picture = picture;
        this.is_active = is_active;
        this.formatted_date = formatted_date;
       // this.message = message;
    }

    public Object address(String street, int zip){
        this.street = street;
        this.zip = zip;
    }

    public String getUid() {
        return uid;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getStreet() {
        return street;
    }
    public int getZip() {
        return zip;
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
    public String getformatted_date() {
        return formatted_date;
    }
   /* public String getMessage() {
        return message;
    } */
}

