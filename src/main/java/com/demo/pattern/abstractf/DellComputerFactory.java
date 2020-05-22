package com.demo.pattern.abstractf;

import com.demo.pattern.entity.DellKeyboard;
import com.demo.pattern.entity.DellMouse;
import com.demo.pattern.entity.Keyboard;
import com.demo.pattern.entity.Mouse;

public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
