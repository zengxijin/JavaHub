package org.jackzeng;

import lombok.Data;

/**
 * @author xijin.zeng created on 2018/9/20
 */
@Data
public class Relation {
    private String src;
    private String dst;
    private String relationship;

    public Relation(String src, String dst, String relationship) {
        this.src = src;
        this.dst = dst;
        this.relationship = relationship;
    }
}
