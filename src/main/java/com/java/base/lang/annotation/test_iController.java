package com.java.base.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jimjian on 2016/10/31.
 */
public class test_iController {

    public static void main(String[] args) {
        try {
            //        判断注解类是否是接口
            if (i$Controller.class.isInterface())
                System.out.println("*类上面的注解：" + i$Controller.class);
            Class<?> clazz = Class.forName("com.java.base.lang.annotation.iController");
            if (clazz.getAnnotation(i$Controller.class) == null) {
                System.out.println();
                return;
            }
            i$RequestMapping iRequestMapping = clazz.getAnnotation(i$RequestMapping.class);
            System.out.println(iRequestMapping.value());

            Map<String, String> map = new HashMap<>();
            //getMethods()只返回public修饰的方法
            //getDeclaredMethods()返回所有修饰的方法，但不包括继承的方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                String str1 = null;
                System.out.println(method.getDeclaringClass());
                if (method.isAnnotationPresent(i$RequestMapping.class)) {
                    i$RequestMapping iRequestMapping1 = method.getAnnotation(i$RequestMapping.class);
                    str1 = iRequestMapping1.value();
                }
                Class<?>[] clazzP = method.getParameterTypes();
                if (clazzP.length != 0) {
                    for (Class c : clazzP) {
                        map.put(str1, c.getName());
                    }
                } else
                    map.put(str1, "null");

                //形参上注解获取
                Annotation[][] annotations2 = method.getParameterAnnotations();
                if (annotations2.length > 0) {
                    for (int i = 0; i < annotations2.length; i++) {
                        for (int j = 0; j < annotations2[i].length; j++) {
                            i$RequestParam i4s = (i$RequestParam) annotations2[i][j];
                            System.out.println("*方法中形参注解：" + i4s.value());
                        }
                    }
                }
            }

            String url = "/iController/method1";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getKey().startsWith("get") || entry.getKey().startsWith("set"))
                    continue;
                if (entry.getValue().equals("null")) {
                    Method method = clazz.getDeclaredMethod(entry.getKey());
                    method.invoke(clazz.newInstance());
                } else if (entry.getValue().equals("java.lang.String")) {
                    Method method = clazz.getDeclaredMethod(entry.getKey(), String.class);
                    method.invoke(clazz.newInstance(), ",带参数");
                }
            }

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                i$Value value = field.getAnnotation(i$Value.class);
                //获取私有权限
                //field.setAccessible(true);
                System.out.println("*Field="+value.value());
            }

            //构造函数获取
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors)
                System.out.println("构造函数：" + constructor);

            //无参构造函数创建
            Constructor constructor1 = clazz.getDeclaredConstructor();
            iController iController1 = (iController) constructor1.newInstance();
            System.out.println("通过构造函数创建：" + iController1);

            //有参构造函数创建
            Constructor constructor2 = clazz.getDeclaredConstructor(String.class);
            //获取私有权限
            constructor2.setAccessible(true);
            iController iController2 = (iController) constructor2.newInstance("jimjian");
            System.out.println("通过构造函数创建：" + iController2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
