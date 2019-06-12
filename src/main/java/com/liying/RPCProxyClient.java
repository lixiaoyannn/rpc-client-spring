package com.liying;

import java.lang.reflect.Proxy;

/**
 * 创建者:小䶮
 */
public class RPCProxyClient {
    public <T> T clentProxy(final Class<T> interfaces,final String host,final int port){
       return (T)Proxy.newProxyInstance(interfaces.getClassLoader(), new Class<?>[]{interfaces},new RemoteInvocationHandle(host,port));
    }
}
