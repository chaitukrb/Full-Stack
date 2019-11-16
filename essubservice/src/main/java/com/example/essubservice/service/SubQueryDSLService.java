package com.example.essubservice.service;

import com.example.essubservice.model.Subscription;
import com.example.essubservice.repository.SubRepo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import java.util.ArrayList;
import java.util.List;

@Service
public class SubQueryDSLService {
    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private SubRepo subRepo;

    public List<Subscription> multiMatchQuery(String text) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
                .field("title").type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();
        List<Subscription> subs = template.queryForList(searchQuery, Subscription.class);
        return subs;
    }

}
