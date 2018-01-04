package org.jackzeng.orientdb;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.tinkerpop.blueprints.impls.orient.OrientDynaElementIterable;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxj
 * @create 2017/12/27
 */
public class CommandExecutor {

    @Getter
    private OrientGraphFactory factory;

    public CommandExecutor(OrientGraphFactory factory) {
        this.factory = factory;
    }

    public List<OrientVertex> execNoTx(String sql) {
        return execNoTx(sql, null);
    }

    public List<OrientVertex> execNoTx(String sql, Object... args) {
        OrientGraphNoTx graph = factory.getNoTx();
        try {
            OrientDynaElementIterable iterable = (args != null && args.length > 0) ?
                    graph.command(new OCommandSQL(sql)).execute(args) : graph.command(new OCommandSQL(sql)).execute();
            return wrapResult(iterable);
        } finally {
            //return the remote connection to pool
            graph.shutdown();
        }
    }

    /**
     * you need to using with try-resources to close connection
     * @param sql
     * @return
     */
    public ResponseContext execNoTxResponse(String sql) {
        OrientGraphNoTx graph = factory.getNoTx();
        OCommandSQL oCommandSQL = new OCommandSQL(sql);

        return ResponseContext.builder()
                .currentNoTxConnection(graph)
                .iterator(graph.command(oCommandSQL).execute())
                .build();
    }

    public List<ODocument> execFetchOnce(String sql) {
        try (ODatabaseDocumentTx database = factory.getDatabase()) {
            return database.query(new OSQLSynchQuery<ODocument>(sql).setFetchPlan("*:-1"));
        }
    }

    private List<OrientVertex> wrapResult(OrientDynaElementIterable iterable) {
        List<OrientVertex> vertexList = new ArrayList<>();
        iterable.forEach(e -> vertexList.add((OrientVertex) e));

        return vertexList;
    }


}
