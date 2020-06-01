package demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 包装Proxy
 */
public class JdkDynamicProxyUtil {
    /**
     *
     * @param targetObject 被代理目标对象
     * @param handler      实现了InvocationHandler对实现类
     * @param <T>
     * @return
     */
    public static <T>T newProxyInstance(T targetObject, InvocationHandler handler){
        ClassLoader classLoader = targetObject.getClass().getClassLoader();
        Class<?>[]  interfaces = targetObject.getClass().getInterfaces();
        return (T)Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
