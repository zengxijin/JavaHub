package org.jackzeng;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.record.impl.ODocumentHelper;
import com.orientechnologies.orient.core.sql.query.OSQLAsynchQuery;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import org.jackzeng.orientdb.CommandExecutor;
import org.jackzeng.orientdb.DBFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zengxj
 * @create 2018/1/18
 */
public class AsyncQueryCase {

    @Test
    public void queryAsynch() {

        String url = "remote:10.18.19.90:2424/kg2";
        String sql = "select from phone where phone ='18139772339' or phone='15901234557'";
        OrientGraphFactory factory = DBFactory.instance(url, "root", "rainbowpass1119");

        ODatabaseDocumentTx database = factory.getDatabase();

        final String sqlOne = "select * from company where id between 4 and 7";
        final String sqlTwo = "select $names let $names = (select EXPAND( addresses.city ) as city from Account where addresses.size() > 0 )";

        final List<ODocument> synchResultOne = database.command(new OSQLSynchQuery<ODocument>(sqlOne)).execute();
        final List<ODocument> synchResultTwo = database.command(new OSQLSynchQuery<ODocument>(sqlTwo)).execute();

        Assert.assertTrue(synchResultOne.size() > 0);
        Assert.assertTrue(synchResultTwo.size() > 0);

        final List<ODocument> asynchResultOne = new ArrayList<ODocument>();
        final List<ODocument> asynchResultTwo = new ArrayList<ODocument>();

        final AtomicBoolean endOneCalled = new AtomicBoolean();
        final AtomicBoolean endTwoCalled = new AtomicBoolean();

        database.command(new OSQLAsynchQuery<ODocument>(sqlOne, new OCommandResultListener() {
            @Override
            public boolean result(Object iRecord) {
                asynchResultOne.add((ODocument) iRecord);
                return true;
            }

            @Override
            public void end() {
                endOneCalled.set(true);

                database.command(new OSQLAsynchQuery<ODocument>(sqlTwo, new OCommandResultListener() {
                    @Override
                    public boolean result(Object iRecord) {
                        asynchResultTwo.add((ODocument) iRecord);
                        return true;
                    }

                    @Override
                    public void end() {
                        endTwoCalled.set(true);
                    }

                    @Override
                    public Object getResult() {
                        return null;
                    }

                })).execute();
            }

            @Override
            public Object getResult() {
                return null;
            }

        })).execute();

        Assert.assertTrue(endOneCalled.get());
        Assert.assertTrue(endTwoCalled.get());

        Assert.assertTrue(ODocumentHelper.compareCollections(database, synchResultTwo, database, asynchResultTwo, null));
        Assert.assertTrue(ODocumentHelper.compareCollections(database, synchResultOne, database, asynchResultOne, null));
    }
}
