package org.jackzeng.orientdb;

import com.orientechnologies.orient.core.command.OCommandResultListener;
import com.orientechnologies.orient.core.sql.query.OSQLNonBlockingQuery;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import lombok.Getter;

import java.util.concurrent.Future;

/**
 * @author zengxj
 * @create 2017/12/28
 */
public class AsyncCommandExecutor {

    @Getter
    private OrientGraphFactory factory;

    public void exec() {
        int resultCount = 0;
        Future future = factory.getDatabase().command(
                new OSQLNonBlockingQuery<Object>(
                        "SELECT FROM Animal WHERE name = 'Gipsy'",
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

    }
}
