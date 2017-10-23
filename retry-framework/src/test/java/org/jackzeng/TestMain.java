package org.jackzeng;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author zengxijin created on 2017/8/23
 */
public class TestMain {
    public static void main(String[] args) {
        ThirdPartyEnum thirdPartyEnum = ThirdPartyEnum.valueOf("ABC");
        System.out.println(thirdPartyEnum);

        Map<String,RetryPolicy> maps = new HashMap<>();
        maps.put("A",new RetryPolicy("AA",3));
        maps.put("B",new RetryPolicy("BB",2));
        maps.put("C",new RetryPolicy("CC",5));
        maps.put("D",new RetryPolicy("DD",8));
        maps.put("E",new RetryPolicy("EE",1));

        Map<String,RetryPolicy> sorted = maps.entrySet().stream()
                .sorted(
                        //Map.Entry.comparingByValue(Comparator.comparing(RetryPolicy::getPriority))
                        //Collections.reverseOrder(Map.Entry.comparingByValue((e1,e2)->(e1.getPriority() - e2.getPriority())))

                        //Comparator.comparing(RetryPolicy::getPriority)
                        Collections.reverseOrder(
                                (e1,e2)->(e1.getValue().getPriority() - e2.getValue().getPriority())
                        )
                )
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1,e2)->e1,
                                LinkedHashMap::new
                        )
                );

        Map unmodify = Collections.unmodifiableMap(sorted);

        unmodify.forEach((k,v)->System.out.println("key:" + k + " v:" + v));

    }
}
