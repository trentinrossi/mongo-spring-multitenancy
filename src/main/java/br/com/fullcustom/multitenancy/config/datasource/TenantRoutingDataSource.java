package br.com.fullcustom.multitenancy.config.datasource;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import br.com.fullcustom.multitenancy.config.web.ThreadTenantStorage;

public class TenantRoutingDataSource extends SimpleMongoClientDatabaseFactory {

    public TenantRoutingDataSource(ConnectionString connectionString) {
        super(connectionString);
    }

    @Override
    public MongoDatabase getMongoDatabase() throws DataAccessException {
        System.out.println("MongoDB getting tenantid: " + ThreadTenantStorage.getTenantId());
        return super.getMongoDatabase(ThreadTenantStorage.getTenantId());
    }

}