package com.example.RestControl.Services;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.RestControl.Gives;

@Service
public class GivesService {
	 private final AtomicLong counter = new AtomicLong(0);
	    private final AtomicLong gcounter = new AtomicLong(0);

	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    LocalDateTime date_created = LocalDateTime.now();
	    String formatted_date = date_created.format(myFormatObj);
	    String extraZipCodes[] = {"'60607'", "'60608'"};
	    
	    Gives g;
	    Gives g3;
	    
	    List<Gives> gList;
	    
	    
	    public List<Gives> getGives() {
	        List<Gives> list = new ArrayList<>();
		    list.add(g);
		    if(g3 != null) {
			    list.add(g3);
		    }
		    return list;
	    }
	    
	    public Gives addGives(Gives newGive) {
			g = new Gives(newGive.getUid(), "<gid1>", newGive.getType(), newGive.getDescription(), newGive.getStart_date(), newGive.getEnd_date(), newGive.getExtra_zip(), newGive.getIs_active(), formatted_date);
			return g;
		}
	    
		public Map updateGives(Gives updatedGive) {
			g3 = new Gives("<uid3>", "<gid1>",  updatedGive.getType(), updatedGive.getDescription(), updatedGive.getStart_date(), updatedGive.getEnd_date(), updatedGive.getExtra_zip(), updatedGive.getIs_active(), updatedGive.getDate_created());
			return null;
	}


}