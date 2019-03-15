package com.snowriver.proxy.jxjdk;

import java.lang.reflect.Method;

public interface JXInvocationHandler {

    Object invoke(Object Proxy, Method method, Object[] args) throws Throwable;

}
