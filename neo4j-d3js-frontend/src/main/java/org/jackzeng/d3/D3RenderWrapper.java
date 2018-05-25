package org.jackzeng.d3;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xijin.zeng created on 2018/5/25
 */
@Data
@Builder
public class D3RenderWrapper<T, E> implements Serializable {
    private T results;
    private E errors;
}
