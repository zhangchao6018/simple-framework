package org.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * 标识被容器管理起来的切面类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    String pointcut();
    //"execution(* com.demo.controller.frontend..*.*(..))"以及within(com.demo.controller.frontend.*)
}
