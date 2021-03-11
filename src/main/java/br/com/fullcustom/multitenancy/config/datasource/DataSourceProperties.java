package br.com.fullcustom.multitenancy.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

    private Map<Object, Object> datasources = new LinkedHashMap<>();

    public Map<Object, Object> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        datasources.forEach((key, value) -> this.datasources.put(key, convert(value)));
    }

    public MongoDatabaseFactory convert(Map<String, String> source) {

        System.out.println("Creating Datasource by properties: " + source);

        return new SimpleMongoClientDatabaseFactory(MongoClients.create(), source.get("tenant"));
    }
}