package org.jackzeng;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author zengxijin created on 2019-04-25
 */
public class TestMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        // simple type test
        // keyword var is introduced in Java 10
        var x = 10;
        System.out.println(x);

        // wrapper bean type test
        var dummy = new DummyType("jack zeng");
        System.out.println(dummy.getName());

        // Map.of和List.of是Java 11新加的，返回的list或者map都是不可变的
        var myMap = Map.of("k1", "v1","k2","v2");
        var myList = List.of(1, 2, 3, 4);

        // you can use var key word in lambda exp in Java 11
        // which is forbidden in Java 10
        Predicate<String> predicate = (var a) -> "test".equals(a);

        // standard HttpClient in JDK is introduced in Java 11
        var quest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        var response = client.send(quest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
}
