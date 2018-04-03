package top.chuqin.thrift.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import top.chuqin.thrift.HelloWordService;
import top.chuqin.thrift.Request;
import top.chuqin.thrift.RequestException;

import java.time.LocalDateTime;

public class HelloWordServiceImpl implements HelloWordService.Iface {
    // 实现这个方法完成具体的逻辑。
    @Override
    public String doAction(Request request) throws RequestException, TException {
        System.out.println("Get request: " + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new RequestException();
        }

        String result = "";

        switch (request.getType()) {
            case SAY_HELLO:
                result = String.format("Hello, %s, Welcome", request.getName());
                break;

            case QUERY_TIME:
                result = String.format("Hello, %s, Welcome, Now is %s", request.getName(), LocalDateTime.now().toString());
                break;

            default:
                throw new RuntimeException("something wrong");
        }

        return result;
    }
}
