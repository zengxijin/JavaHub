package org.jackzeng.domain.node;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jackzeng.domain.BaseNode;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Car extends BaseNode {
    private String brand;
}
