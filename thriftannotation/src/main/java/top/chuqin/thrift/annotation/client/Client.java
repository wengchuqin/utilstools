package top.chuqin.thrift.annotation.client;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import top.chuqin.thrift.annotation.server.HelloService;
import top.chuqin.thrift.annotation.server.User;


import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThriftClientManager clientManager = new ThriftClientManager();
        FramedClientConnector connector = new FramedClientConnector(new InetSocketAddress("localhost", 9988));

        User user = new User();
        user.setName("wcq,");
        user.setEmail("wcq@gmail.com");


        HelloService helloService = clientManager.createClient(connector, HelloService.class).get();
        String hi = helloService.sayHello(user);
        System.out.println(hi);
    }
}
