package com.java.base.jvm.classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by jimjian on 2016/10/26.
 */
public class test_URLClassLoader {
    public static void main(String[] args) {
        try {
            URL urls[] = new URL[1];
            urls[0] = new URL("file:d:\\Hello.jar");
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("Hello");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            Object object = constructors[0].newInstance();
            Method method = clazz.getMethod("say");//,String.class);//调用say(String name)
            method.invoke(object);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
