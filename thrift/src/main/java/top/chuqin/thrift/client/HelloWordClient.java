package top.chuqin.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import top.chuqin.thrift.HelloWordService;
import top.chuqin.thrift.Request;
import top.chuqin.thrift.RequestType;

public class HelloWordClient {
    public static void main(String[] args) {
        try {
            // 设置调用的服务地址-端口
            TTransport transport = new TSocket("localhost", 9090);
            // 使用二进制协议
            TProtocol protocol = new TBinaryProtocol(transport);
            // 使用的接口
            HelloWordService.Client client = new HelloWordService.Client(protocol);
            // 打开socket
            transport.open();

            Request request = new Request();
            request.setAge(10);
            request.setName("wengchuqin");
            request.setType(RequestType.QUERY_TIME);

            String ret = client.doAction(request);
            System.out.println(ret);

            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException te) {
            te.printStackTrace();
        }
    }
}
