package org.jackzeng;

/**
 * Created by zengxj on 17-10-19
 */
public class LambdaSample {

    private int index = 0;

    private void executeDummy(DummyInterface dummyInterface) {
        dummyInterface.dummy();
    }

    public void execute() {
        executeDummy(() -> {
            for (int i = 100; i > 0; i--){
                index = i;
            }
        });
    }
}
