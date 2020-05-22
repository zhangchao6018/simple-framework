package com.demo.pattern.abstractf;

import com.demo.pattern.entity.Keyboard;
import com.demo.pattern.entity.Mouse;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerFactory cf = new HpComputerFactory();
        Mouse mouse = cf.createMouse();
        Keyboard keyboard = cf.createKeyboard();
        mouse.sayHi();
        keyboard.sayHello();
    }
}
