package com.liying;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 创建者:小䶮
 */
public class RPCNetTrasport {
    private String host;
    private int port;

    public RPCNetTrasport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object sent(RPCRequest request){
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Socket socket = null;
        Object result = null;
        try{
            socket = new Socket(host,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());//网络socket
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            objectInputStream = new ObjectInputStream(socket.getInputStream());
            result = objectInputStream.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
