package org.jackzeng;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

/**
 * @author zengxj
 * @create 2018/1/22
 */
public class CloseableDriver implements AutoCloseable {

    private final Driver driver;

    public CloseableDriver(String uri, String user, String pwd) {
        this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, pwd));
    }

    @Override
    public void close() throws Exception {
        if (driver != null) {
            driver.close();
        }
    }

    public Session newSession() {
        return driver.session();
    }
}
