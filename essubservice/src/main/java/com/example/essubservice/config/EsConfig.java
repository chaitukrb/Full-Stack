//package com.example.essubservice.config;
//import java.io.IOException;
//
////import org.elasticsearch.node.NodeBuilder;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//import org.elasticsearch.client.Client;
//import org.springframework.beans.factory.annotation.Value;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.example.essubservice.repository")
//@ComponentScan(basePackages = { "com.example.essubservice.service" })
//public class EsConfig {
//
//    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/6.8.4}")
//    private String elasticsearchHome;
//
//    @Value("${elasticsearch.cluster.name:esapp}")
//    private String clusterName;
//
//    @Bean
//    public Client client() throws UnknownHostException {
//        Settings elasticsearchSettings = Settings.builder()
//                .put("client.transport.sniff", true)
//                .put("path.home", elasticsearchHome)
//                .put("cluster.name", clusterName).build();
//
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
//        return client;
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
//        return new ElasticsearchTemplate(client());
//    }
//}