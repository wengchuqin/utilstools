package top.chuqin.utils.tools.restfulapidemo.web.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.chuqin.utils.tools.restfulapidemo.dto.SuccessDto;

/**
 * 包装json对象。
 */
@ControllerAdvice
@Component
public class SuccessJsonAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //top.chuqin.utils.tools.restfulapidemo.web包下面的controller类，返回结果都进行包装
        if (returnType.getExecutable().getClass().getName().startsWith("top.chuqin.utils.tools.restfulapidemo.web")) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        return new SuccessDto(body);
    }

}
