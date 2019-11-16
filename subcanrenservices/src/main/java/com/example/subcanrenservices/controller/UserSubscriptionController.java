package com.example.subcanrenservices.controller;

import com.example.subcanrenservices.model.Subscription;

//import com.example.subcanrenservices.repository.ActionRepo;
import com.example.subcanrenservices.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/*
controllers for subscribe, cancel, renewal
 */

@RestController
@RequestMapping("/user")
public class UserSubscriptionController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;


    @RequestMapping(value = "/subscribe/subid={s_id}", method = RequestMethod.GET)
    public String getSubscription(@PathVariable String s_id, @RequestHeader("uid") Long id) {
        String url="http://localhost:8088/subs/"+s_id;
        Subscription response = restTemplate.getForObject(url, Subscription.class);

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.MONTH, Math.toIntExact(response.getDuration()));
        Date date1 = c.getTime();
        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(date1);

        userSubscriptionRepository.Subscribe(id, response.getId(), date2);

        return "You are Subscribed to "+response.getTitle();
    }

    @RequestMapping(value="/cancel/subid={s_id}", method = RequestMethod.GET)
    public String UnSubscribe(@PathVariable String s_id, @RequestHeader("uid") Long id) {
        String url="http://localhost:8088/subs/"+s_id;
        Subscription response = restTemplate.getForObject(url, Subscription.class);
        userSubscriptionRepository.UnSubscribe(id,response.getId());
        return "You are Unsubscribed to "+response.getTitle();
    }

    @RequestMapping(value = "/renewal/subid={s_id}", method = RequestMethod.GET)
    public String Renewal(@PathVariable String s_id, @RequestHeader("uid") Long id) throws ParseException {
        String url="http://localhost:8088/subs/"+s_id;
        Subscription response = restTemplate.getForObject(url, Subscription.class);
        String date = userSubscriptionRepository.getSubEndDate(id ,response.getId());
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        c.add(Calendar.MONTH, Math.toIntExact(response.getDuration()));
        Date date2 = c.getTime();
        String date3 = new SimpleDateFormat("yyyy-MM-dd").format(date2);

        userSubscriptionRepository.Renewal(id,response.getId(), date3);
        return "Done";
    }

    @RequestMapping(value = "/subs", method = RequestMethod.GET)
    public List<Subscription> UserSubs(@RequestHeader("uid") Long id) {
        List<Long> arr = userSubscriptionRepository.UserSubs(id);
        List<Subscription> subs = new ArrayList<Subscription>();
        for(int i=0;i<arr.size();i++) {
            String url="http://localhost:8088/subs/"+ arr.get(i);
            Subscription response = restTemplate.getForObject(url, Subscription.class);
            subs.add(response);
        }
        return subs;
    }


//    public Subscription[] getAllSubs(@PathVariable String s_id) {
//        String url="http://localhost:8088/subs/";
//        Subscription[] response  = restTemplate.getForObject(url, Subscription[].class);
//        return response;
//    }

}
