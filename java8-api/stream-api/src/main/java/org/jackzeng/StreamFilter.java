package org.jackzeng;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by XijinZeng on 2017/5/18.
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("jack","zeng","java","hi");

        //print all element
        words.forEach(System.out::println);

        //one condition
        List<String> results = words.stream()
                .filter(x->x.equals("java"))
                .collect(Collectors.toList());
        results.forEach(System.out::println);

        //mutil condition
        List<String> results2 = words.stream()
                .filter(x-> x !=null && x.length() > 3)
                .collect(Collectors.toList());
        results2.forEach(System.out::println);


    }
}
