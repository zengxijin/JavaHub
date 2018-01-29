package org.jackzeng.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengxj
 * @create 2018/1/29
 */
public class TeatMain {

    public static void main(String[] args) {
        Map<String, Person> personMap = new HashMap<>();

        Person p1 = Person.builder()
                .name("p1")
                .age(10)
                .address(new Address("SH","abc1"))
                .build();

        Person p2 = Person.builder()
                .name("p2")
                .age(11)
                .address(new Address("BJ","abc2"))
                .build();

        Person p3 = Person.builder()
                .name("p3")
                .age(13)
                .address(new Address("AA","abc3"))
                .build();

        Person p4 = Person.builder()
                .name("p4")
                .age(14)
                .address(new Address("SZ1","abc4"))
                .build();

        Person p5 = Person.builder()
                .name("p5")
                .age(15)
                .address(new Address("XA","abc5"))
                .build();

        personMap.put("p1", p1);
        personMap.put("p2", p2);
        personMap.put("p3", p3);
        personMap.put("p4", p4);
        personMap.put("p5", p5);

        for (Map.Entry<String, Person> personEntry : personMap.entrySet()) {
            Address address = personEntry.getValue().getAddress();
            if (address.getCity() != null && address.getCity().equals("SZ")) {
                System.out.println("found SZ");
            }
        }
        //the code above could rewrite below in Java 8 Stream style
        personMap.entrySet().stream()
                .map(e -> e.getValue().getAddress())
                .filter(a -> {
                    System.out.println("HAHA");
                    return a.getCity().equals("SZ");
                })
                .findFirst()
                .ifPresent(a -> System.out.println(a.getCity()));
    }
}
