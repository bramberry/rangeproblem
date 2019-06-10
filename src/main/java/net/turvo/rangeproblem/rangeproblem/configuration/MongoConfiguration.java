package net.turvo.rangeproblem.rangeproblem.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {
    @Value(value = "${spring.data.mongodb.database}")
    private String databaseName;
    @Value(value = "${spring.data.mongodb.host}")
    private String host;
    @Value(value = "${spring.data.mongodb.port}")
    private Integer port;
    @Value(value = "${mongodb.connections}")
    private Integer connectionsCount;

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().connectionsPerHost(connectionsCount).build();
        return new MongoClient(new ServerAddress(host, port), mongoClientOptions);
    }
}
