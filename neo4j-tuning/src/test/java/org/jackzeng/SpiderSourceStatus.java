package org.jackzeng;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zengxj
 * @create 2018/1/26
 */
public enum SpiderSourceStatus {

    INITIALIZE("INITIALIZE"),
    RUNNING("RUNNING"),
    OK("OK"),
    //OK2("OK"),
    EXCEPTION("EXCEPTION"),
    EXCEPTION123("123");

    private final String status;

    private static Map<String, SpiderSourceStatus> formatMap = Stream.of(SpiderSourceStatus.values())
            .collect(Collectors.toMap(s -> s.status, Function.identity()));

    SpiderSourceStatus(String status) {
        this.status = status;
    }

    public String value() {
        return this.status;
    }

    public static SpiderSourceStatus fromCode(final String status) {
        SpiderSourceStatus responseCode = formatMap.get(status);
        if (responseCode == null) {
            throw new IllegalArgumentException(status + " has no corresponding value");
        }
        return responseCode;
    }
}
