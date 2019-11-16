package com.example.emailservice.listener;

import com.example.emailservice.model.News;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsConsumer {
    @KafkaListener(topics = "kafka_news")
    public void consumeJson(List<News> news) {
        //System.out.println("Consumed JSON Message: " + news);
    }
}
