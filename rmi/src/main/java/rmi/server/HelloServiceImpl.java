package rmi.server;

import rmi.common.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * 我们必须让实现类继承 java.rmi.server.UnicastRemoteObject 类，
 * 此外，必须提供一个构造器，并且构造器必须抛出
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }


}
