package org.jackzeng;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author zengxj
 * @create 2018/1/26
 */
public class TestMain {

    public static void main(String[] args) {
        SpiderSourceStatus spiderSourceStatus = fromCode("1234");
    }

    public static SpiderSourceStatus fromCode(final String status) {
        Optional<SpiderSourceStatus> spiderSourceStatus =
                Optional.ofNullable(Arrays.asList(SpiderSourceStatus.values()).stream()
                        .filter(e -> e.value().equals(status))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(status + " has no corresponding value")));

        return spiderSourceStatus.get();
    }
}
