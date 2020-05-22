package com.demo.pattern.method;

import com.demo.pattern.entity.LenovoMouse;
import com.demo.pattern.entity.Mouse;

public class LenovoMouseFactory  implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
