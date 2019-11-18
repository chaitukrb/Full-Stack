package com.example.mailservice;

import com.example.mailservice.model.user.User;
import com.example.mailservice.model.usersubscription.UserSubscription;
import com.example.mailservice.user.repository.UserRepository;
import com.example.mailservice.usersub.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class MailserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserviceApplication.class, args);
    }

}
