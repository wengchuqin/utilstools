package rmi.client;

import rmi.common.HelloService;

import java.rmi.Naming;

public class RmiClient {

    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:1099/rmi.server.HelloServiceImpl";
        //客户端接口需要与服务端接口一样（这里的“一样”是指接口名、方法名、参数列表和方法返回值类型一样）
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}
