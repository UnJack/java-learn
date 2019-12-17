package com.java.base.jdk1_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test_1_8_Stream {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Apple", 20),
                new User("张三", 11),
                new User("王五", 91)
        );
        System.out.println("stream range():" + IntStream.range(10, 20).boxed().collect(Collectors.toList()));
        System.out.println("stream rangeClosed():" + IntStream.rangeClosed(10, 20).boxed().collect(Collectors.toList()));
//        合并集合,flatMap

        System.out.println("stream flatMap()" + Stream.of(
                Arrays.asList(new User("李四", 44)),
                Arrays.asList(new User("张三", 8))
        ).flatMap(child -> child.stream()).collect(Collectors.toList()));

//         去重,distinct;必须重写对应泛型的hashCode()和equals()方法,与Map Object作为key的原理一样
//        System.out.println("java 8 stream distinct");
//        list.stream().distinct().forEach(user -> {
//            System.out.println("distinct user = " + user);
//        });

        System.out.println("stream distinct():" + Stream.of("北京", "北京", "江西").distinct().collect(Collectors.toList()));
        System.out.println("stream sorted():" + users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList()));
        System.out.println("stream filter():" + users.stream().filter(user -> (user.getName()).equals("张三")).collect(Collectors.toList()));
        System.out.println("stream count(): " + users.stream().filter(user -> (user.getName()).equals("Apple")).count());


        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        System.out.println("stream generate():" + Stream.generate(random).filter(integer -> integer > 0).limit(10).collect(Collectors.toList()));
        // 截断集合
        System.out.println("stream limit():" + users.stream().sorted(Comparator.comparing(User::getAge)).limit(3).collect(Collectors.toList()));
        System.out.println("stream iterate():" + Stream.iterate(0, n -> n + 3).limit(6).collect(Collectors.toList()));
        // 获取一个对象
        User u = users.stream().filter(user -> user.getName().equals("Apple")).findAny().orElse(null);
        System.out.println("User = " + u);
        // 获取对象的元素
        // map把数据流中的T转换成一个元素
        String name = users.stream().filter(user -> user.getName().equals("Apple1")).map(User::getName).findAny().orElse(a());
        System.out.println("1111 ->"+users.stream().filter(user -> user.getName().equals("Apple1")).map(temp -> a()).findAny().get());
        System.out.println("name = " + name);
        // 获取对象的元素
        String xx = users.stream().filter(user -> user.getName().equals("Apple")).map(User::getName).findAny().orElseGet(() -> a());
        System.out.println("name = " + xx);

        System.out.println("mmmml");
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        System.out.println(Stream.of("one", "two", "three", "four").collect(Collectors.joining("=")));

        System.out.println("random to stream:" + new Random().ints().limit(10).boxed().collect(Collectors.toList()));
        System.out.println("111----");
        Stream.of(1, 2, 3, 3, 4).peek(p -> System.out.println("peek:" + p)).forEach(a -> System.out.println("foreach:" + a));
//        Stream.of(1,2,3,3,4).forEach(e-> System.out.println(e));
    }

    public static String a() {
        return "bbb";
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}