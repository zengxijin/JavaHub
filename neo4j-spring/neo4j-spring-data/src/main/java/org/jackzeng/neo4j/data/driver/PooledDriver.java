package org.jackzeng.neo4j.data.driver;

import org.neo4j.driver.v1.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zengxijin created on 2018/4/17
 * PooledDriver is the wrapper for neo4j remote server connection pool
 */
public class PooledDriver {

    private String serverUrl;

    private String userName;

    private String password;

    private Driver driver;

    public PooledDriver(String serverUrl, String userName, String password) {
        this.serverUrl = serverUrl;
        this.userName = userName;
        this.password = password;

        this.init();
    }

    private void init() {
        this.driver = GraphDatabase.driver(serverUrl, AuthTokens.basic(userName, password), Config.build()
                .withMaxConnectionLifetime(30, TimeUnit.MINUTES)
                .withMaxConnectionPoolSize(50)
                .withConnectionAcquisitionTimeout(2, TimeUnit.MINUTES)
                .withConnectionTimeout(10, TimeUnit.SECONDS)
                .toConfig());

        addCloseHook();
    }

    /**
     * Session for CURD
     * @return Session
     */
    public Session newSession() {
        return driver.session();
    }

    /**
     * Session just for Query
     * @return Session
     */
    public Session newReadonlySession() {
        return driver.session(AccessMode.READ);
    }

    /**
     * add hook to pooled driver when JVM shutdown and release the resources
     */
    private void addCloseHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                super.run();

                if (driver != null) {
                    driver.close();
                    System.out.println("PooledDriver is closed");
                }
            }
        });
    }


}
