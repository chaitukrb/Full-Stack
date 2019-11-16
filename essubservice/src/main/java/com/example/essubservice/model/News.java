package com.example.essubservice.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "gonuclei", type = "News", shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    String id;
    String content;
    String subid;
}
