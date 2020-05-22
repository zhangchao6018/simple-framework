package com.demo.pattern.abstractf;

import com.demo.pattern.entity.Keyboard;
import com.demo.pattern.entity.LenovoKeyboard;
import com.demo.pattern.entity.LenovoMouse;
import com.demo.pattern.entity.Mouse;

public class LenovoComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LenovoKeyboard();
    }
}
