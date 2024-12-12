package com.java.base;

import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jimjian on 2016/8/24.
 * https://github.com/patterncat/agent-demo
 */
public class test {
    public static void main(String[] args) {

        Map map = new ConcurrentHashMap();
        map.put("12", "21");
        map.put("13", "22");
        map.put("14", "23");
        map.put("15", "24");
        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("key = " + o + ",value = " + o2);
            }
        });


        System.out.println("1111111 -> " + Stream.of(1, 2, 3, 4).filter(i -> i == 266).findAny().orElseGet(() -> {

            return 1222222222;
        }));

        System.out.println("1111111 -> " + Stream.of(1, 2, 3, 4).filter(i -> i == 2).findAny().map(a -> {
            return 666666;
        }).get());

        System.out.println("1111111 -> " + Stream.of(1, 2, 3, 4).filter(i -> i == 2).findAny().map(a->{
            return 1;
        }).get());

    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }
}