package org.jackzeng;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

import java.util.concurrent.TimeUnit;

/**
 * @author zengxj
 * @create 2018/1/22
 */
public class PooledDriver {

    private final Driver driver;

    public PooledDriver(String uri, String user, String pwd) {
        this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, pwd), Config.build()
                .withMaxConnectionLifetime(30, TimeUnit.MINUTES)
                .withMaxConnectionPoolSize(50)
                .withConnectionAcquisitionTimeout(2, TimeUnit.MINUTES)
                .withConnectionTimeout(2, TimeUnit.SECONDS)
                .toConfig());
    }
}
