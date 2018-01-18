package org.jackzeng.orientdb.async;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLNonBlockingQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Future;

/**
 * @author zengxj
 * @create 2018/1/18
 */
@AllArgsConstructor
public class OSqlAsyncExecutor {

    @Getter
    @Setter
    private OrientGraphFactory factory;

    /**
     * for Async non-PreparedStatement sql query
     * NOTE: the Future.get will use futureGetHandler to wrapper return result
     * @param sql
     * @param eachRecordHandler
     * @param endQueryHandler
     * @param futureGetHandler
     * @return Future
     */
    public Future exec(String sql, EachRecordHandler eachRecordHandler, EndQueryHandler endQueryHandler, FutureGetHandler futureGetHandler) {
        return exec(sql, eachRecordHandler, endQueryHandler, futureGetHandler, null);
    }

    /**
     * for Async PreparedStatement sql query
     * all *Handler supposed to use lambda impl to make callback
     * NOTE: the Future.get will use futureGetHandler to wrapper return result
     * @param sql
     * @param eachRecordHandler
     * @param endQueryHandler
     * @param futureGetHandler
     * @param args
     * @return Future
     */
    public Future exec(String sql,
                       EachRecordHandler eachRecordHandler, EndQueryHandler endQueryHandler, FutureGetHandler futureGetHandler,
                       final Object... args) {
        try (ODatabaseDocumentTx database = factory.getDatabase()) {

            OSQLNonBlockingQuery nonBlockingQuery = new OSQLNonBlockingQuery<ODocument>(sql, new OCommandResultListener() {
                @Override
                public boolean result(Object iRecord) {
                    return eachRecordHandler.each(iRecord);
                }

                @Override
                public void end() {
                    endQueryHandler.end();
                }

                @Override
                public Object getResult() {
                    return futureGetHandler.get();
                }
            });

            return (args == null || args.length == 0) ?
                    database.query(nonBlockingQuery) : database.query(nonBlockingQuery, args);
        }
    }
}
