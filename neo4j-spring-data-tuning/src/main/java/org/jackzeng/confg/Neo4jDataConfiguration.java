package org.jackzeng.confg;

import org.jackzeng.driver.PooledDriver;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xijin.zeng created on 2018/4/24
 */
@Order(0)
@Configuration
@ComponentScan(basePackages = {"org.jackzeng"})
@EnableNeo4jRepositories(basePackages = "org.jackzeng.repository")
@EnableTransactionManagement
public class Neo4jDataConfiguration {

    @Value("${spring.data.neo4j.uri}")
    private String url;

    @Value("${spring.data.neo4j.username}")
    private String user;

    @Value("${spring.data.neo4j.password}")
    private String pwd;

    @Bean
    public PooledDriver buildPooledDriver() {
        return new PooledDriver(url, user, pwd);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "org.jackzeng.domain");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        //default connectionPoolSize is 50
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri(url)
                .credentials(user, pwd)
                .build();
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
