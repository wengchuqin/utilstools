远程方法调用 thrift
# 定义thrift
Test.thrift

# 生成java代码
```
thrift --gen java Test.thrift
```
## 结果
top.chuqin.thrift这个包（不包过子目录）的代码，全是自动生成的

# 实现接口
```
top.chuqin.thrift.impl.HelloWordServiceImpl
```

# 开启服务器
```
top.chuqin.thrift.server.HelloWordServer
```

# 开启客户端
```
top.chuqin.thrift.client.HelloWordClient
```