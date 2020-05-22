package com.demo.pattern.abstractf;

import com.demo.pattern.entity.Keyboard;
import com.demo.pattern.entity.Mouse;

/**
 * 抽象工厂--套装
 */
public interface ComputerFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
