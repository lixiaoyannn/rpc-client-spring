package com.liying;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RPCProxyClient rpcProxyClient = new RPCProxyClient();
        IHellloService iHellloService = rpcProxyClient.clentProxy
                (IHellloService.class,"localhost",8080);
        Object result = iHellloService.sayhello("liying");
        System.out.println(result);
    }
}
