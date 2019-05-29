package org.jackzeng.ml;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * @author xijin.zeng created on 2018/8/13
 */
public class ServerNode {
    public static void main(String... args) {
        new Thread(() -> {
            IgniteConfiguration configuration = new IgniteConfiguration();
            configuration.setClientMode(false);

            try (Ignite ignite = Ignition.start(configuration)) {
                Thread.currentThread().join();
            }
            catch (InterruptedException ignore) { }
        }).start();
    }
}
