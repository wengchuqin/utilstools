# 定义全局异常
top.chuqin.utils.tools.restfulapidemo.web.advice.GlobalExceptionHandle
发生异常时，生成一个唯一的code。把code和异常信息记录到日志中。
同时，把code返回给前端，保证异常可跟踪。

# 包装json对象
top.chuqin.utils.tools.restfulapidemo.web.advice.SuccessJsonAdvice
返回json给前端时，为json打一个时间戳。