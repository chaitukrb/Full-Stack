package com.example.essubservice.repository;

import com.example.essubservice.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubRepo extends ElasticsearchRepository<Subscription,String> {
    List<Subscription> findByTitle(String title, Pageable pageable);


    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\"], \"fuzziness\": \"AUTO\"}}")
    Page<Subscription> find(String q, Pageable pageable);

}
