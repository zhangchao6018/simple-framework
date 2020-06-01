package org.simpleframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.simpleframework.aop.PointcutLocator;

@AllArgsConstructor
@Getter
public class AspectInfo {
    //执行顺序
    private int orderIndex;
    //DefaultAspect实现类
    private DefaultAspect aspectObject;
    private PointcutLocator pointcutLocator;
}
