package com.demo.pattern.abstractf;

import com.demo.pattern.entity.HpKeyboard;
import com.demo.pattern.entity.HpMouse;
import com.demo.pattern.entity.Keyboard;
import com.demo.pattern.entity.Mouse;

public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
