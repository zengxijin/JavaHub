package org.jackzeng;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLAsynchQuery;
import com.orientechnologies.orient.core.sql.query.OSQLNonBlockingQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import org.jackzeng.orientdb.AsyncCommandExecutor;
import org.jackzeng.orientdb.DBFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zengxj
 * @create 2018/1/18
 */
public class AsyncCommandExecutorTest {

    String url = "remote:10.18.19.90:2424/kg2";
    String sql = "select from Loan";
    AsyncCommandExecutor executor = new AsyncCommandExecutor(DBFactory.instance(url, "root", "rainbowpass1119"));

    OrientGraphFactory factory = DBFactory.instance(url, "root", "rainbowpass1119");

    @Test
    public void asyncCommandTest() throws Exception {
        final List<ODocument> asyncBuffer = new ArrayList<ODocument>();
        final AtomicBoolean isDone = new AtomicBoolean();
        final AtomicInteger count = new AtomicInteger();

        //Future future = factory.getDatabase().command(
        factory.getDatabase().command(
                new OSQLAsynchQuery<ODocument>(sql, new OCommandResultListener() {

                    // for each record
                    @Override
                    public boolean result(Object iRecord) {
                        if (iRecord == null) {
                            return false;
                        }

                        int i = count.incrementAndGet();
                        System.out.println("result " + i);
                        asyncBuffer.add((ODocument) iRecord);

                        return true;
                    }

                    @Override
                    public void end() {
                        System.out.println("query finish");
                    }

                    @Override
                    public Object getResult() {
                        System.out.println("get result");
                        return asyncBuffer;
                    }
                })
        ).execute();

        //OSQLAsynchQuery command can't do with future
        //future.get();
    }

    @Test
    public void asyncQueryTest() throws Exception {

        final List<ODocument> asyncBuffer = new ArrayList<>();
        final AtomicBoolean isDone = new AtomicBoolean();

        Future future = factory.getDatabase().query(
                new OSQLNonBlockingQuery<ODocument>(sql, new OCommandResultListener() {

                    @Override
                    public boolean result(Object iRecord) {
                        if (iRecord == null) {
                            return false;
                        }

                        asyncBuffer.add((ODocument) iRecord);
                        System.out.println("result count " + asyncBuffer.size());

                        return true;
                    }

                    @Override
                    public void end() {
                        isDone.set(true);
                    }

                    //for future.get result
                    @Override
                    public Object getResult() {
                        return "123";
                    }
                })
        );

        //wait for finish
        Object obj = future.get();
    }
}
