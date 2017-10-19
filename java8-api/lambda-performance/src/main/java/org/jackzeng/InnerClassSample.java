package org.jackzeng;

/**
 * Created by zengxj on 17-10-19
 */
public class InnerClassSample {

    private int index = 0;

    private void executeDummy(DummyInterface dummyInterface) {
        dummyInterface.dummy();
    }

    public void execute() {
        executeDummy(new DummyInterface() {
            @Override
            public void dummy() {
                for (int i = 100; i > 0; i--){
                    index = i;
                }
            }
        });

    }
}
