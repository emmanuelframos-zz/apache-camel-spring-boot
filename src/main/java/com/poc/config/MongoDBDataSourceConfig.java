package com.poc.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Arrays;

@Data
@EqualsAndHashCode(callSuper=false)
@Configuration
@EnableMongoRepositories("com.poc.repository")
public class MongoDBDataSourceConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    @Getter(AccessLevel.NONE)
    private String host;

    @Value("${spring.data.mongodb.port}")
    @Getter(AccessLevel.NONE)
    private Integer port;

    @Value("${spring.data.mongodb.database}")
    @Getter(AccessLevel.NONE)
    private String database;

    @Value("${spring.data.mongodb.username}")
    @Getter(AccessLevel.NONE)
    private String username;

    @Value("${spring.data.mongodb.password}")
    @Getter(AccessLevel.NONE)
    private String password;

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public String getDatabaseName() {
        return database;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        return new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));
    }
}