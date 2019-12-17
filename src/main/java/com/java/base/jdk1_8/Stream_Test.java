package com.java.base.jdk1_8;

import com.java.base.common.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Test {

    public static void main(String[] args) throws IOException {
        System.out.println(Stream.of(1, 2, 22, 111, 1233, 21).collect(Collectors.toList()));
        System.out.println(Stream.of(1, 2, 22, 111, 1233, 21).map(integer -> integer + 1).collect(Collectors.toList()));
        System.out.println(Stream.of(1, 2, 22, 111, 1233, 21).unordered().collect(Collectors.toList()));
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).unordered().collect(Collectors.toList()));
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).reduce(Integer::sum).get());
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).reduce(9, Integer::sum));
        System.out.println(Stream.of(1, 3, 3, 4, 4, 6).collect(Collectors.groupingBy(Integer::intValue)));

//        Stream.of(1, 3, 3, 4, 4, 6).collect(Collectors.groupingBy(Integer::intValue)).forEach(System.out::println);

        int i = Stream.iterate(1, a -> a + 1).limit(100).parallel().reduce(0, Integer::sum);

        System.out.println("i = " + i);


        File file = new File("README.md");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            System.out.println("bufferedReader.lines().collect(Collectors.toList()) = " + bufferedReader.lines().collect(Collectors.toList()));
            if (bufferedReader.lines().count() == 0) {
                System.out.println(bufferedReader.lines().count());
                break;

            }
        }


    }

}
