package org.jackzeng;

import com.orientechnologies.orient.core.record.impl.ODocument;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import org.jackzeng.orientdb.CommandExecutor;
import org.jackzeng.orientdb.DBFactory;
import org.jackzeng.orientdb.ResponseContext;
import org.junit.Test;

import java.util.List;

/**
 * @author zengxj
 * @create 2017/12/27
 */
public class DBFactoryTest {

    String url = "remote:ip:2424/kg2";
    String sql = "select from phone where phone ='13820999729' or phone='13265447240'";
    CommandExecutor commandExecutor = new CommandExecutor(DBFactory.instance(url,"root","aaa"));

    @Test
    public void instanceTest() throws Exception {
        List<OrientVertex> vertexList = commandExecutor.execNoTx(
                sql
        );
        vertexList.forEach(e -> {
            System.out.println(e.getId());
            System.out.println((String) e.getProperty("phone"));
        });
    }

    @Test
    public void iterableTest() throws Exception {
        try (ResponseContext responseContext = commandExecutor.execNoTxResponse(sql)) {
            responseContext.getIterator().forEach(
                    e -> {
                        OrientVertex v = (OrientVertex) e;
                        System.out.println(v.getId());
                        System.out.println((String) v.getProperty("phone"));
                        // error: Database is closed
                        // OrientDynaElementIterable will fetch result every time from remote db,
                        // if you shutdown(), next iterate will failed for the connection is closed
                        // responseContext.getCurrentNoTxConnection().shutdown();
                    }
            );
        }
    }

    String traverseSql = "select traversedVertex(-1, 9), $path, $depth from " +
            "(traverse * from (select from phone where phone = '13820999729' or phone = '15115796065') while $depth < 9 strategy BREADTH_FIRST) " +
            "where @class = 'Loan' and $depth > 0 ";

    @Test
    public void fetchAllTest() throws Exception {

        List<ODocument> resultset = commandExecutor.execFetchOnce(traverseSql);

        resultset.forEach(
                d -> {
                    //System.out.println(d.getClassName());
                    System.out.println((String) d.field("$path"));
                }
        );

    }
}
