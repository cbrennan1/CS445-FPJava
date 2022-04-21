package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;   
import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter; 


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class Asks {
	private String uid;
	private String aid;
	private String type;
	private String description;
	private String start_date;
	private String end_date;
	private String[] extra_zip;
	private boolean is_active;
	private String date_created;
	
	public Asks(String uid, String aid, /*String type,*/ String description, String start_date, String end_date, String[] extra_zip, boolean is_active, String date_created) {
		this.uid = uid;
		this.aid = aid;
		//this.type = type;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.extra_zip = extra_zip;
		this.is_active = is_active;
		this.date_created = date_created;
	}

	
	public String getUid() {
		return uid;
	}
	public String getAid() {
		return aid;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public String[] getExtra_zip() {
		return extra_zip;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public String getDate_created() {
		return date_created;
	}
}
