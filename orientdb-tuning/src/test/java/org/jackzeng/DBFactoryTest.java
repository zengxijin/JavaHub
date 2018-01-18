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

    String url = "remote:10.18.19.90:2424/kg2";
    String sql = "select from phone where phone ='18139772339' or phone='15901234557'";
    CommandExecutor commandExecutor = new CommandExecutor(DBFactory.instance(url,"root","rainbowpass1119"));

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
            "(traverse * from (select from phone where phone = '18139772339' or phone = '15901234557') while $depth < 9 strategy BREADTH_FIRST) " +
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

    String testSql = "select traversedVertex(-1, 9), $path, $depth from (traverse * from (select from phone where phone = '15846886222') while $depth < 9 strategy BREADTH_FIRST) " +
            "where @class = 'Loan' and $depth > 0 and not ($path like '%WORK%') and not ($path like '%CALL%') and $path like '%OWN%'";

    String testPreparedSql = "select traversedVertex(-1, 9), $path, $depth from (traverse * from (select from phone where phone =?) while $depth < 9 strategy BREADTH_FIRST) " +
            "where @class = 'Loan' and $depth > 0 and not ($path like '%WORK%') and not ($path like '%CALL%') and $path like '%OWN%'";

    @Test
    public void sqlTest() throws Exception {
        List<OrientVertex> vertexList = commandExecutor.execNoTx(testSql);
        vertexList.forEach(v -> {
            System.out.println((String) v.getProperty("$path"));
        });
    }

    @Test
    public void preparedSqlTest() throws Exception {
        List<OrientVertex> vertexList = commandExecutor.execNoTx(testPreparedSql,"15846886222");
        vertexList.forEach(v -> {
            System.out.println((String) v.getProperty("$path"));
        });
    }
}
