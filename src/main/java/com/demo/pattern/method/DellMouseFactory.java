package com.demo.pattern.method;

import com.demo.pattern.entity.DellMouse;
import com.demo.pattern.entity.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
