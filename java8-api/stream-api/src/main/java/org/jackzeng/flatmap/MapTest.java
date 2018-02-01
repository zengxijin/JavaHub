package org.jackzeng.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zengxj
 * @create 2018/1/31
 */
public class MapTest {

    public static void main(String[] args) {
        String[] strs = {"Hello", "World"};
        Stream<String[]> stream = Arrays.stream(strs).map(s -> s.split(""));
        stream.forEach(strings -> Arrays.asList(strings).forEach(s -> System.out.println(s)));

        List<String> list = Arrays.stream(strs)
                .flatMap(s -> Arrays.stream(s.split("")))
                .collect(Collectors.toList());
        list.forEach(System.out::println);


        List<String> list1 = Stream.of(strs)
                .flatMap(s -> Stream.of(s.split("")))
                .collect(Collectors.toList());
        list1.forEach(System.out::println);
    }
}
