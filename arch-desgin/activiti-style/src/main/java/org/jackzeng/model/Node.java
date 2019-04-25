package org.jackzeng.model;

import java.util.List;

/**
 * @author xijin.zeng created on 2018/12/17
 */
public interface Node {

    List<Node> getNodes();

    String getRuleScript();

    boolean isLeafNode();

    Object exec();
}
