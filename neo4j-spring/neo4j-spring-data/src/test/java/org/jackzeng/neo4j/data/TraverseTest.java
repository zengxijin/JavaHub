package org.jackzeng.neo4j.data;

import org.jackzeng.neo4j.data.driver.PooledDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.internal.InternalNode;
import org.neo4j.driver.internal.InternalPath;
import org.neo4j.driver.internal.InternalRelationship;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author xijin.zeng created on 2018/5/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TraverseTest {

    @Autowired
    private PooledDriver driver;

    @Test
    public void cypherTraverse() throws Exception {
        String cypher = "match(a:Agency {age:24})-[x*..4]-(y) return a,x,y";
        try (Session session = driver.newReadonlySession()) {
            StatementResult result = session.run(cypher);
            while (result.hasNext()) {
                List<Record> list = result.list();
                if (list != null) {
                    list.forEach(
                            record -> {
                                InternalNode node = (InternalNode)record.get("y").asNode();
                                //System.out.println(record.get("a").asPath());
                                System.out.println("");
                                printNodeInfo(node);
                            }
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这里的路径遍历和反序列化，Path这个数据类型会将路径中的所有Nodes和Relationship都返回回来
     * @throws Exception
     */
    @Test
    public void cypherPath() throws Exception {
        String cypher = "match p=(:Agency {age:24})-[*0..3]-() return p";
        try (Session session = driver.newReadonlySession()) {
            StatementResult result = session.run(cypher);
            while (result.hasNext()) {
                List<Record> list = result.list();
                if (list != null) {
                    System.out.println(list.size());
                    list.forEach(
                            record -> {
                                InternalPath path = (InternalPath)record.get("p").asPath();
                                System.out.println(path);

                                path.nodes().forEach(e -> printNodeInfo((InternalNode)e));
                                path.relationships().forEach(e -> printRelationship((InternalRelationship)e));
                            }
                    );
                }
            }
        }
    }

    private void printNodeInfo(InternalNode node) {
        //labels
        System.out.print("Label:");
        node.labels().forEach(
                label -> {
                    System.out.print(label + " ");
                }
        );
        //values
        Map<String, Object> pros = node.asMap();
        pros.entrySet().forEach(
                pro -> {
                    System.out.println(pro.getKey() + ":" + pro.getValue());
                }
        );
    }

    private void printRelationship(InternalRelationship relationship) {
        System.out.println("Relationship Type:" + relationship.type());
        Map<String, Object> pros = relationship.asMap();
        if (pros != null && pros.size() > 0) {
            pros.entrySet().forEach(
                    pro -> {
                        System.out.println(pro.getKey() + ":" + pro.getValue());
                    }
            );
        }
    }
}
