package org.jackzeng;

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

    CloseableDriver driver = new CloseableDriver("bolt://192.168.56.101:7687","neo4j","zengxijin123");

    @Test
    public void queryTest() throws Exception {
        try (Session session = driver.newSession()) {
            StatementResult result = session.run("MATCH (l:Loan)-[:APPLY]-(person)-[:OWN]-(appPhone)-[:CALL]-(callPhones) " +
                    "where l.loanId=456 " +
                    "return distinct 1,person,appPhone,callPhones");

            while (result.hasNext()) {
                Record record = result.next();
                Node person = record.get("person").asNode();
                Node appPhone = record.get("appPhone").asNode();
                Node callPhones = record.get("callPhones").asNode();

                System.out.println(person.get("name").asString());
                System.out.println(appPhone.get("cellPhone").asString());
                System.out.println(callPhones.get("cellPhone").asString());
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
