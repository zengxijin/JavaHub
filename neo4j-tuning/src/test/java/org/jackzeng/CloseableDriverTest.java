package org.jackzeng;

import org.junit.Before;
import org.junit.Test;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.types.Node;

/**
 * @author zengxj
 * @create 2018/1/22
 */
public class CloseableDriverTest {

    //CloseableDriver driver = new CloseableDriver("bolt://192.168.56.101:7687","neo4j","zengxijin123");
    CloseableDriver driver = new CloseableDriver("bolt://172.16.191.128:7687","neo4j","zengxijin123");

    @Before
    public void insertNodes() {
        // (1) using DETACH DELETE can delete node and its relationship
        // (2) using DELETE just delete node
        try (Session session = driver.newSession()) {
            session.run("MATCH (n:Loan { loanId: '12345', amount: 10000 }) DETACH DELETE n");
            session.run("CREATE (n:Loan { loanId: '12345', amount: 10000 })");

            session.run("MATCH (n:Phone { phoneNo:'137123456789' }) DETACH DELETE n");
            session.run("CREATE (n:Phone { phoneNo:'137123456789' })");

            session.run("MATCH (n:Phone { phoneNo:'138001380000' }) DETACH DELETE n");
            session.run("CREATE (n:Phone { phoneNo:'138001380000' })");

            session.run("MATCH (n:Person { ssn:'210123198810051234' } ) DETACH DELETE n");
            session.run("CREATE (n:Person { ssn:'210123198810051234' } )");

            session.run("MATCH (p:Person),(l:Loan) " +
                    "WHERE p.ssn='210123198810051234' AND l.loanId='12345' " +
                    "CREATE (p)-[r:APPLY]->(l) " +
                    "RETURN type(r)");
            session.run("MATCH (p:Person),(ph:Phone) " +
                    "WHERE p.ssn='210123198810051234' AND ph.phoneNo='137123456789' " +
                    "CREATE (p)-[r:OWN]->(ph) " +
                    "RETURN type(r)");
            session.run("MATCH (p1:Phone),(p2:Phone) " +
                    "WHERE p1.phoneNo='137123456789' AND p2.phoneNo='138001380000' " +
                    "CREATE (p1)-[r:CALL]->(p2) " +
                    "RETURN type(r) ");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void queryTest() throws Exception {
        try (Session session = driver.newSession()) {
            StatementResult result = session.run("MATCH (loan:Loan)-[:APPLY]-(person:Person)-[:OWN]-(appPhone:Phone)-[:CALL]-(callPhones:Phone) " +
                    "where loan.loanId='12345' " +
                    "return distinct loan,person,appPhone,callPhones");

            while (result.hasNext()) {
                Record record = result.next();
                Node loan = record.get("loan").asNode();
                Node person = record.get("person").asNode();
                Node appPhone = record.get("appPhone").asNode();
                Node callPhones = record.get("callPhones").asNode();

                System.out.println(loan.get("amount").asDouble());
                System.out.println(person.get("ssn").asString());
                System.out.println(appPhone.get("phoneNo").asString());
                System.out.println(callPhones.get("phoneNo").asString());
            }
        }
    }

//    StatementResult result = tx.run( "MATCH (a)-[:KNOWS]->(b) RETURN a.name, b.name" );
//    while ( result.hasNext() )
//    {
//        Record record = result.next();
//        System.out.println( String.format( "%s knows %s", record.get( "a.name" ).asString(), record.get( "b.name" ).toString() ) );
//    }
//    return result;
}
