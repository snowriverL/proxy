package com.snowriver.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeiPo implements InvocationHandler {

    /**
     * 保存被代理对象得引用
     */
    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        System.out.println("实际执行结果：" + invoke + " ,参数=== " + target + " : " + args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println("我是媒婆： 我要给你找对象， 现在已经拿到你的需求");
        System.out.println("开始物色");
    }
    private void after(){
        System.out.println("如果合适的话， 就准备办事");
    }
}