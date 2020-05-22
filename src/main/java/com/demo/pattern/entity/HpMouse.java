package com.demo.pattern.entity;

public class HpMouse  implements Mouse {
    @Override
    //@TestAnnotation
    public void sayHi() {
        System.out.println("我是惠普鼠标");
    }
}
