package org.jackzeng;

import org.junit.Test;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 * @author zengxijin created on 2018/4/16
 */
public class PooledDriverTest {

    private final PooledDriver pooledDriver = new PooledDriver("bolt://localhost:7687","neo4j","zengxijin123");

    @Test
    public void driverTest() throws Exception {
        try (Session session = pooledDriver.newSession()) {
            StatementResult result = session.run("MATCH (n) RETURN count(*) as total_nodes");

            long total = result.single().get("total_nodes").asLong();
            System.out.println(total);
        }
    }
}
