package org.jackzeng.manager;

import org.jackzeng.manager.entity.User;

/**
 * XxxManager 表示的是一类型的操作接口的集合
 *
 * @author xijin.zeng created on 2018/11/20
 */
public interface UserManager {
    
    void addUser(String userId);

    void deleteUser(String userId);

    User findUserById(String userId);
}
