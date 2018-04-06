package top.chuqin.utils.tools.restfulapidemo.web.advice;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.chuqin.utils.tools.restfulapidemo.dto.FailDto;
import top.chuqin.utils.tools.restfulapidemo.exception.BusinessException;
import top.chuqin.utils.tools.restfulapidemo.exception.DuplicateOrgNameException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@ControllerAdvice
@Component
public class GlobalExceptionHandle {
//    @ExceptionHandler(BusinessException.class)
//    @ResponseBody
//    public FailDto businessException(HttpServletRequest request, HttpServletResponse response, BusinessException e){
//        FailDto failDto = new FailDto();
//        failDto.setCode(-1);
//        failDto.setMessage(e.getMessage());
//        failDto.setDesciption(Arrays.toString(e.getStackTrace()));
//        return failDto;
//    }

    @ExceptionHandler(DuplicateOrgNameException.class)
    public void duplicateOrgNameException(HttpServletRequest request, HttpServletResponse response, DuplicateOrgNameException e){
        FailDto failDto = new FailDto();
        failDto.setCode(-1);
        failDto.setMessage(e.getMessage());
        failDto.setDesciption(Arrays.toString(e.getStackTrace()));
        writeJsonToResponse(failDto, response);
    }


    private void writeJsonToResponse(FailDto failDto, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        try {
            String json = JSON.toJSONString(failDto);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
