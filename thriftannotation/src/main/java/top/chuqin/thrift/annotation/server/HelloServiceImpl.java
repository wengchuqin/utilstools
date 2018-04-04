package top.chuqin.thrift.annotation.server;

public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(User user) {
        return String.format("hello, %s, %s", user.getName(), user.getEmail());
    }
}
