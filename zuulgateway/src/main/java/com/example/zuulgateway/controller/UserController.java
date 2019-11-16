package com.example.zuulgateway.controller;


import com.example.zuulgateway.repository.UserRepository;
import com.example.zuulgateway.security.CurrentUser;
import com.example.zuulgateway.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private SubscriptionRepository subscriptionRepository;
// @CurrentUser UserPrincipal currUser

//    @GetMapping("/api/auth/hi")
//    public String Yoo() {
//        String s = "hi";
//        return s;
//    }

//    @GetMapping("/api/auth/curruser")
//    public Long CurrUserId(@CurrentUser UserPrincipal currUser) {
//        Long val = currUser.getId();
//        return currUser.getId();
//    }
//    @GetMapping("/user/sub")
//    public List<Subscription> getUserSubscriptions(@CurrentUser UserPrincipal currentUser) {
//        return subscriptionRepository.findAllUserSub(currentUser.getUsername());
//    }
//
//    @PostMapping("/user/subscribe/sub_name={s_name}")
//    public void Subscribe(@PathVariable(value = "s_name") String s_name,
//                          @CurrentUser UserPrincipal currentUser
//    ) {
//
//
//        //String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        Date date = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//
//        Subscription sub = subscriptionRepository.SubDuration(s_name);
//
//        c.add(Calendar.MONTH, Math.toIntExact(sub.getDuration()));
//        Date date1 = c.getTime();
//        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
//
//        userRepository.Subscribe(currentUser.getUsername(),s_name, date2);
//    }
//
//    @PostMapping("/user/cancel/sub_name={s_name}")
//    public void CancelSub(@PathVariable(value = "s_name") String s_name,
//                          @CurrentUser UserPrincipal currentUser
//                          ) {
//        userRepository.CancelSub(currentUser.getId(),s_name);
//    }
//
//    @PostMapping("/user/renewal/sub_name={s_name}")
//    public void RenewalSub(@PathVariable(value = "s_name")String s_name,
//                           @CurrentUser UserPrincipal currentUser
//                           ) throws ParseException {
//
//        String date = userRepository.getSubEndDate(currentUser.getId() ,s_name);
//        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
//        Calendar c = Calendar.getInstance();
//        c.setTime(date1);
//
//        Subscription sub = subscriptionRepository.SubDuration(s_name);
//
//        c.add(Calendar.MONTH, Math.toIntExact(sub.getDuration()));
//        Date date2 = c.getTime();
//        String date3 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
//
//        userRepository.RenSub(currentUser.getId(),s_name, date3);
//    }

}
