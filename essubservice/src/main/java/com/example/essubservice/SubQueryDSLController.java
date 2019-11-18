package com.example.essubservice;

import com.example.essubservice.model.News;
import com.example.essubservice.model.Subscription;
import com.example.essubservice.repository.NewsRepo;
import com.example.essubservice.repository.SubRepo;
import com.example.essubservice.service.SubQueryDSLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;
import javax.management.Query;
import java.util.*;

@RestController
public class SubQueryDSLController {
    @Autowired
    private SubQueryDSLService service;
    @Autowired
    private SubRepo subRepo;
    @Autowired
    private NewsRepo newsRepo;
    @Autowired
    private  KafkaTemplate<String, News> kafkaTemplate;

    private static final String TOPIC = "kafka_news";

    // gives all the list of Subscriptions
    @GetMapping("/subs")
    public List<Subscription> findAllSubs() {
        List<Subscription> subList = new ArrayList<>();
        Iterable<Subscription> subs = subRepo.findAll();
        subs.forEach(subList::add);
        return subList;
    }

    //fuzzy search similar to search engine
    @GetMapping("subs/find/{var}")
    public Page<Subscription> Find(@PathVariable String var) {
        Page page = subRepo.find(var, PageRequest.of(0, 10));
        return page;
    }

    //gives a single Subscription based on id
    @GetMapping("subs/{id}")
    public Optional<Subscription> findById(@PathVariable String id) {
        return subRepo.findById(id);
    }

    @GetMapping("/news")
    public List<News> findAllNews() {
        List<News> newsList = new ArrayList<>();
        Iterable<News> news = newsRepo.findAll();
        news.forEach(newsList::add);
        return newsList;
    }

    //adding new Subscriptions
    @PostMapping("/subs")
    public int saveSubs(@RequestBody List<Subscription> subscriptions) {
        subRepo.saveAll(subscriptions);
        return subscriptions.size();
    }
    //adding new news
    @PostMapping("/news")
    public int saveNews(@RequestBody List<News> news) {
        newsRepo.saveAll(news);
        //kafkaTemplate.send(TOPIC, news);
        for(int i=0;i<news.size();i++) {
            kafkaTemplate.send(TOPIC, news.get(i));
        }
        return news.size();
    }

    //get all Subscriptions in sorted by params(id, title)
    @GetMapping("/subs/sortby={var}")
    public List<Subscription> SortBy(@PathVariable String var) {
        List<Subscription> subscriptionList = new ArrayList<>();
        Iterable<Subscription> subs = subRepo.findAll();
        subs.forEach(subscriptionList::add);
        if(var.equals("id"))
            Collections.sort(subscriptionList, new SortbyId());
        else if(var.equals("title"))
            Collections.sort(subscriptionList, new SortbyTitle());
        return subscriptionList;
    }

    //
    @GetMapping("subs/filter={var}")
    public List<Subscription> FilterSubs(@PathVariable String var) {
        return service.multiMatchQuery(var);
    }


}

class SortbyId implements Comparator<Subscription> {
    public int compare(Subscription a, Subscription b)
    {
        return a.getId().compareTo(b.getId());
    }
}

class SortbyTitle implements Comparator<Subscription> {
    public int compare(Subscription a, Subscription b)
    {
        return a.getTitle().compareTo(b.getTitle());
    }
}