package com.example.RestControl;
// Test


public class accounts {
    private final long uid;
    private String name;
    private String address;
    private String street;
    private int zip;
    private String phone;
    private String picture;
    private boolean is_active;
    private String date_created;
    private String message;

    /*
    public accounts() {

    }
*/
    public accounts(long uid, String name, String address, String street, int zip, String phone, String picture, boolean is_active, String date_created, String message) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.street = street;
        this.zip = zip;
        this.phone = phone;
        this.picture = picture;
        this.is_active = is_active;
        this.date_created = date_created;
        this.message = message;
    }


    public long getUid() {
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
    public String getDate_created() {
        return date_created;
    }
    public String getMessage() {
        return message;
    }
}

