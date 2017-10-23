package org.jackzeng;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author zengxijin created on 2017/8/25
 */
public class TimeMinus {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime oldTime = LocalDateTime.now();
        Thread.sleep(10000);
        LocalDateTime newTime = LocalDateTime.now();

        System.out.println(
                ChronoUnit.SECONDS.between(oldTime,newTime)
        );
    }
}
