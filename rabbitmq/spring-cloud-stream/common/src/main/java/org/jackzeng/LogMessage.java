package org.jackzeng;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xijin.zeng created on 2019/8/6
 */
@Data
public class LogMessage implements Serializable {

    private String message;

    public LogMessage(String message) {
        this.message = message;
    }
}
