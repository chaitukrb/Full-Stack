package com.example.mailservice.listener;

import com.example.mailservice.user.repository.UserRepository;
import com.example.mailservice.usersub.repository.UserSubscriptionRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.mailservice.model.News;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;

// consumes news from kafka topic and sends mails to the users

@Service
public class NewsConsumer {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "kafka_news",groupId = "json")
    public void consumeJson(String news) {
        Gson g = new Gson();
        News p = g.fromJson(news, News.class);  //Json string parsing to class
        List<Long> ids = userSubscriptionRepository.getSubscribedUsers(p.getSubid());

        SimpleMailMessage msg = new SimpleMailMessage();

        // list of email ids of users for the respective subscription
        List<String> emails = new ArrayList<>();
        for(int i=0;i<ids.size();i++) {
            emails.add(userRepository.getEmails(ids.get(i)));
            msg.setTo(emails.get(i));
            msg.setSubject("Here's your news from Spring Boot");
            msg.setText(p.getContent());
            javaMailSender.send(msg);
        }
        System.out.println(emails);
    }
}
