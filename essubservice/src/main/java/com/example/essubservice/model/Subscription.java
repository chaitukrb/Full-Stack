package com.example.essubservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "nuclei", type = "subscription", shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    private String id;
    private String title;
    private int price;
    private int duration;
}
