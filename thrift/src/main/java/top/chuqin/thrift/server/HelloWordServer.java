package top.chuqin.thrift.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import top.chuqin.thrift.HelloWordService;
import top.chuqin.thrift.impl.HelloWordServiceImpl;

public class HelloWordServer {

    public static void main(String[] args) throws Exception {
        try {
            // 设置服务器端口
            TServerSocket serverTransport = new TServerSocket(9090);
            // 设置二进制协议工厂
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            // 处理器关联业务实现
            HelloWordService.Processor<HelloWordService.Iface> processor = new HelloWordService.Processor<>(
                    new HelloWordServiceImpl());
            //使用单线程标准阻塞I/O模型
            TServer.Args simpleArgs = new TServer.Args(serverTransport)
                    .processor(processor)
                    .protocolFactory(protocolFactory);
            TServer server = new TSimpleServer(simpleArgs);
            System.out.println("开启thrift服务器，监听端口：9090");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
