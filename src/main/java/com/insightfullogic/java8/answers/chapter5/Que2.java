package com.insightfullogic.java8.answers.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @Description:
 * @Author: Mingze Li
 * @Date: 2019/7/8 17:46
 */
public class Que2 {

    public static void main(String[] args) {
        two();

    }
    public static void one(){
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

//        String s = names.collect(maxBy(comparing(String::length))).get();
//        System.out.println(s);
        String s1 = names.max(comparing(String::length)).get();
        System.out.println(s1);

//        String s = names.reduce((acc, name) -> acc.length() > name.length() ? acc : name).get();
//        System.out.println(s);
    }

    public static void two(){
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> collect = names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        collect.forEach((name,time)-> System.out.println(name + ":" + time));
    }
}