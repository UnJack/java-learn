package com.java.base.lang.annotation;

/**
 * Created by jian.jie on 2016/10/31.
 */
@i$Controller
@i$RequestMapping(value = "iController")
public class iController {

    @i$Value(value = "jianjie")
    private String name;

    @i$Value(value = "25")
    public String age;

    public iController() {
    }

    private iController(String name) {
        this.name = name;
    }

    @i$RequestMapping(value = "method1")
    public void method1() {
        System.out.println("method result:/iController/method1");
    }

    @i$RequestMapping(value = "method2")
    public void method2(@i$RequestParam(value = "@i$RequestParam") String string) {
        System.out.println("method result:/iController/method2" + string);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
