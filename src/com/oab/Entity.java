package com.oab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bao on 2017/6/24.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Entity {
    boolean firstLevelCache() default false;

    boolean secondLevelCache() default true;

    String tableName() default "";

    String split() default "";
}
