package org.jackzeng.orientdb;

import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;

/**
 * @author zengxj
 * @create 2017/12/27
 */
public class DBFactory {
    private final static int POOL_MIN_SIZE = 10;
    private final static int POOL_MAX_SIZE = 100;

    private static OrientGraphFactory FACTORY = null;

    public static OrientGraphFactory instance(String url) {
        return init(url, null, null);
    }

    public static OrientGraphFactory instance(String url, String name, String pwd) {
        return init(url, name, pwd);
    }

    private static OrientGraphFactory init(String url, String name, String pwd) {
        if (FACTORY == null) {
            synchronized (DBFactory.class) {
                if (FACTORY == null) {
                    if (name == null) {
                        FACTORY = new OrientGraphFactory(url).setupPool(POOL_MIN_SIZE, POOL_MAX_SIZE);
                    }
                    FACTORY = new OrientGraphFactory(url, name, pwd).setupPool(POOL_MIN_SIZE, POOL_MAX_SIZE);
                }
            }
        }
        return FACTORY;
    }
}
