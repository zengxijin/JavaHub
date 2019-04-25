package org.jackzeng.manager;

import org.jackzeng.cmd.Session;
import org.jackzeng.cmd.SessionFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author xijin.zeng created on 2018/11/20
 */
public class ManagerFactory {

    private Map<Class<?>, SessionFactory> sessionFactories = new HashMap<>();
    private Map<Class<?>, Session> sessions = new HashMap<>();

    @SuppressWarnings({"unchecked"})
    public <T> T getSession(Class<T> sessionClass) {
        Session session = sessions.get(sessionClass);

        if (Objects.isNull(session)) {
            SessionFactory sessionFactory = sessionFactories.get(sessionClass);
            if ( Objects.isNull(sessionFactory) ) {
                throw new RuntimeException("no session factory founded for " + sessionClass.getName());
            }

            session = sessionFactory.openSession();
            sessions.put(sessionClass, session);
        }

        return (T) session;
    }


    public UserManager getUserManager() {
        return getSession(UserManager.class);
    }

}
