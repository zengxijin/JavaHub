package org.jackzeng.orientdb;

import com.tinkerpop.blueprints.impls.orient.OrientDynaElementIterable;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import lombok.Builder;
import lombok.Data;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author zengxj
 * @create 2017/12/27
 */
@Data
@Builder
public class ResponseContext implements Closeable {
    private OrientGraphNoTx currentNoTxConnection;
    private OrientGraph     currentTxConnection;

    private OrientDynaElementIterable iterator;

    /**
     * release the current connection to pool
     */
    private void disconnect() {
        if (currentNoTxConnection != null) {
            currentNoTxConnection.shutdown();
        }

        if (currentTxConnection != null) {
            currentTxConnection.shutdown();
        }
    }

    @Override
    public void close() throws IOException {
        this.disconnect();
    }
}
