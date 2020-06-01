package org.simpleframework.aop.aspect;

import java.lang.reflect.Method;

/**
 * 定义框架支持什么Advice   切面类必须继承它
 */
public abstract class DefaultAspect {
    /**
     * 事前拦截--钩子函数(用户可选择实现)
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @throws Throwable
     */
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable{

    }
    /**
     * 事后拦截--钩子函数(用户可选择实现)
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param returnValue 被代理的目标方法执行后的返回值
     * @throws Throwable
     */
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable{
        return returnValue;
    }
    /**
     *
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param e 被代理的目标方法抛出的异常
     * @throws Throwable
     */
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args,  Throwable e) throws Throwable{

    }
}
