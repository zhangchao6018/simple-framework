package com.demo.annotation;

/**
 * 测试自定义注解
 *      光定义注解还无法满足需求
 *      注解+反射
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        TestCourse testCourse = new TestCourse();
        testCourse.getCourseInfo();
        System.out.println("finish");
    }
}
