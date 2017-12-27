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
        OrientGraphNoTx graph = factory.getNoTx();
        try {
            return wrapResult(
                    graph.command(new OCommandSQL(sql)).execute()
            );
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

    public ResponseContext execNoTxResponse(String sql, boolean isFetchAll) {
        OrientGraphNoTx graph = factory.getNoTx();
        OCommandSQL oCommandSQL = null;
        if (!isFetchAll) {
            oCommandSQL = new OCommandSQL(sql);
        } else {
            //Fetches recursively the entire tree
            oCommandSQL = new OCommandSQL(sql).setFetchPlan("*:-1");
        }

        return ResponseContext.builder()
                .currentNoTxConnection(graph)
                .iterator(graph.command(oCommandSQL).execute())
                .build();
    }


    private List<OrientVertex> wrapResult(OrientDynaElementIterable iterable) {
        List<OrientVertex> vertexList = new ArrayList<>();
        iterable.forEach(e -> vertexList.add((OrientVertex) e));

        return vertexList;
    }
}
