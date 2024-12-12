package com.java.base.lang.annotation;

import java.lang.annotation.*;

/**
 * Created by jimjian on 2016/8/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface i$Controller {
    String value() default "";
}
