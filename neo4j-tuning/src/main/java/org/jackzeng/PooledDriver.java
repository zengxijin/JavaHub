package org.jackzeng;

import org.neo4j.driver.v1.*;

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

        addCloseHook();
    }

    public Session newSession() {
        return driver.session();
    }

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
