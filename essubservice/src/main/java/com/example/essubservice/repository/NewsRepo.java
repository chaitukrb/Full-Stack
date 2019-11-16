package com.example.essubservice.repository;

import com.example.essubservice.model.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends ElasticsearchRepository<News, String> {
    List<News> findBySubid(String subid, Pageable pageable);
}