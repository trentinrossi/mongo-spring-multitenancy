package br.com.fullcustom.multitenancy.config.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import br.com.fullcustom.multitenancy.config.web.ThreadTenantStorage;

@Configuration
public class DataSourceConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        if (ThreadTenantStorage.getTenantId() == null) {
            return "default";
        }

        return ThreadTenantStorage.getTenantId();
    }

    @Override
    public MongoDatabaseFactory mongoDbFactory() {
        // TODO Auto-generated method stub
        return super.mongoDbFactory();
    }

    

}