package com.java.base.lang.annotation;

import java.lang.annotation.*;

/**
 * Created by JianJie on 16/9/7.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface i$Value {
    String value() default "";
}
