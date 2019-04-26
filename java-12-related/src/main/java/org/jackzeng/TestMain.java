package org.jackzeng;

/**
 * @author zengxijin created on 2019-04-25
 * need to add --enable-preview to compiler options if using jdk-12 preview version
 * Java Compiler->additional command line in paramters
 */
public class TestMain {
    public static void main(String[] args) {
        String a = "1";
        System.out.println(getVal("2"));
    }

    private static int getVal(String x) {
        int y = switch (x) {
            case "1" -> 1;
            default -> 2;
        };

        return y;
    }
}
