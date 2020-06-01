package demo.pattern.proxy;

import demo.pattern.proxy.cglib.AlipayMethodInterceptor;
import demo.pattern.proxy.cglib.CglibUtil;
import demo.pattern.proxy.impl.CommonPayment;
import demo.pattern.proxy.impl.ToBPaymentImpl;
import demo.pattern.proxy.impl.ToCPaymentImpl;
import demo.pattern.proxy.jdkproxy.AlipayInvocationHandler;
import demo.pattern.proxy.jdkproxy.JdkDynamicProxyUtil;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;

/**
 * 动态代理
 */
public class ProxyDemo {
    public static void main(String[] args) {
          //1. 静态代理  --对n个接口增强需要n个代理类（实现这些接口）
//        ToCPayment toCProxy = new AlipayToC(new ToCPaymentImpl());
//        toCProxy.pay();
//        ToBPayment toBProxy = new AlipayToB(new ToBPaymentImpl());
//        toBProxy.pay();
          // 2. jdk动态代理
        ToCPayment toCPaymentJdk = new ToCPaymentImpl();
        //这两步可以提取出来
        InvocationHandler handler = new AlipayInvocationHandler(toCPaymentJdk);
        ToCPayment toCProxyJdk = JdkDynamicProxyUtil.newProxyInstance(toCPaymentJdk,handler);
        toCProxyJdk.pay();
        ToBPayment toBPayment = new ToBPaymentImpl();
        //
        InvocationHandler handlerToB = new AlipayInvocationHandler(toBPayment);
        ToBPayment toBProxy = JdkDynamicProxyUtil.newProxyInstance(toBPayment, handlerToB);
        toBProxy.pay();

        //3. cjlib
        CommonPayment commonPayment = new CommonPayment();
//        AlipayInvocationHandler invocationHandler = new AlipayInvocationHandler(commonPayment);
//        CommonPayment commonPaymentProxy = JdkDynamicProxyUtil.newProxyInstance(commonPayment, invocationHandler);
        MethodInterceptor methodInterceptor = new AlipayMethodInterceptor();
        CommonPayment commonPaymentProxy = CglibUtil.createProxy(commonPayment, methodInterceptor);
        commonPaymentProxy.pay();
        ToCPayment toCPayment = new ToCPaymentImpl();
        ToCPayment toCProxy = CglibUtil.createProxy(toCPayment, methodInterceptor);
        toCProxy.pay();
    }
}
