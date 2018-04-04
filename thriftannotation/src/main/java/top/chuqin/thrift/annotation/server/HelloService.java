package top.chuqin.thrift.annotation.server;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

@ThriftService
public interface HelloService {
    @ThriftMethod
    String sayHello(User user);
}
