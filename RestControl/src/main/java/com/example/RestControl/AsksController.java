package com.example.RestControl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AtomicLong counter = new AtomicLong(0);

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);

    Asks a0 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + counter.getAndIncrement() + ">", "type", "description",  "2022-03-14", ["60607", "60608"], true, formatted_date);
    Asks a1 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + counter.getAndIncrement() + ">", "type", "description",  "2022-03-14", ["60607", "60608"], true, formatted_date);
    Asks a2 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + counter.getAndIncrement() + ">", "type",  "description",  "2022-03-14", ["60607", "60608"], true, formatted_date);
       
    @RequestMapping(value = "/bn/api/asks", method = RequestMethod.GET)
    public List<asks> getAsks() {
        List<asks> list = new ArrayList<>();
        list.add(a0);
        list.add(a1);
        list.add(a2);
        return list;
    }
}
