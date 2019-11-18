package com.example.mailservice.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.example.mailservice.model.usersubscription.UserSubscription;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "usersubEntityManagerFactory", transactionManagerRef = "usersubTransactionManager", basePackages = {
        "com.example.mailservice.usersub.repository" })
public class UserSubscriptionDBConfig {
    @Bean(name = "usersubDataSource")
    @ConfigurationProperties(prefix = "spring.usersub.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "usersubEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usersubEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("usersubDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.mailservice.model.usersubscription").persistenceUnit("UserSubscription").build();
    }

    @Bean(name = "usersubTransactionManager")
    public PlatformTransactionManager usersubTransactionManager(
            @Qualifier("usersubEntityManagerFactory") EntityManagerFactory usersubEntityManagerFactory) {
        return new JpaTransactionManager(usersubEntityManagerFactory);
    }
}
