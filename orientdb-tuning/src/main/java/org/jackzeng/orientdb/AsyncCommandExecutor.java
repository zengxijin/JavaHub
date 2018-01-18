package org.jackzeng.orientdb;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.sql.query.OSQLNonBlockingQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Future;

/**
 * @author zengxj
 * @create 2017/12/28
 */
@AllArgsConstructor
public class AsyncCommandExecutor {

    @Getter
    @Setter
    private OrientGraphFactory factory;

    public Future exec(String sql) {
        int resultCount = 0;

        Future future = factory.getDatabase().command(
                new OSQLNonBlockingQuery<Object>(
                        sql,
                        new OCommandResultListener() {

                            /**
                             * This method is called for each result.
                             * @param iRecord
                             * @return
                             */
                            @Override
                            public boolean result(Object iRecord) {
                                // ENTER YOUR CODE HERE
                                System.out.print("callback " + resultCount + " invoked");
                                return true;
                            }

                            /**
                             * for clean up resource
                             */
                            @Override
                            public void end() {
                            }

                            @Override
                            public Object getResult() {
                                return null;
                            }
                        }
                )
        ).execute();

        return future;

    }
}
