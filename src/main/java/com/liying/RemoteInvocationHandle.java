package com.liying;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建者:小䶮
 */
public class RemoteInvocationHandle implements InvocationHandler{
    private String host;
    private int port;

    public RemoteInvocationHandle(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        RPCRequest rpcRequest = new RPCRequest();
        rpcRequest.setClassname(method.getDeclaringClass().getName());
        rpcRequest.setMothodName(method.getName());
        rpcRequest.setPrams(args);

        RPCNetTrasport netTrasport = new RPCNetTrasport("localhost",8080);
        Object object = netTrasport.sent(rpcRequest);
        return object;
    }
}
