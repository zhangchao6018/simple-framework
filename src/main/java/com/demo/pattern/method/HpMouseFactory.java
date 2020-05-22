package com.demo.pattern.method;

import com.demo.pattern.entity.HpMouse;
import com.demo.pattern.entity.Mouse;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
