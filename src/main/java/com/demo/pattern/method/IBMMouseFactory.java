package com.demo.pattern.method;

import com.demo.pattern.entity.IBMMouse;
import com.demo.pattern.entity.Mouse;

public class IBMMouseFactory extends LenovoMouseFactory {
    @Override
    public Mouse createMouse(){
        return new IBMMouse();
    }
}
