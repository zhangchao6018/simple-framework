package com.demo.pattern.simple;

import com.demo.pattern.entity.DellMouse;
import com.demo.pattern.entity.HpMouse;
import com.demo.pattern.entity.LenovoMouse;
import com.demo.pattern.entity.Mouse;

/**
 * 简单工厂
 * 没新增一种需求,需要在工厂类新增代码,违背开闭原则
 */
public class MouseFactory {
    public static Mouse createMouse(int type){
        switch (type) {
            case 0: return new DellMouse();
            case 1: return new HpMouse();
            case 2: return new LenovoMouse();
            default: return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }
}
