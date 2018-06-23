package top.chuqin.utils.tools.restfulapidemo.web.advice;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.chuqin.utils.tools.restfulapidemo.dto.FailDto;
import top.chuqin.utils.tools.restfulapidemo.exception.BusinessException;
import top.chuqin.utils.tools.restfulapidemo.exception.DuplicateOrgNameException;
import top.chuqin.utils.tools.restfulapidemo.service.LongUuidService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Arrays;

@ControllerAdvice
@Component
public class GlobalExceptionHandle {
    @Autowired
    private LongUuidService longUuidService;

    private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(BusinessException.class)
    public void businessException(HttpServletRequest request, HttpServletResponse response, BusinessException e) {
        long code = longUuidService.genUuid();
        LOG.trace("exception({}), {}", code, e.getStackTrace());

        FailDto failDto = new FailDto();
        failDto.setCode(code);
        failDto.setMessage(e.getMessage());
        failDto.setDesciption(Arrays.toString(e.getStackTrace()));
        writeJsonToResponse(failDto, response);
    }

    @ExceptionHandler(DuplicateOrgNameException.class)
    public void duplicateOrgNameException(HttpServletRequest request, HttpServletResponse response, DuplicateOrgNameException e) {
        long code = longUuidService.genUuid();
        LOG.trace("exception({}), {}", code, e.getStackTrace());

        FailDto failDto = new FailDto();
        failDto.setCode(code);
        failDto.setMessage(e.getMessage());
        writeJsonToResponse(failDto, response);
    }


    private void writeJsonToResponse(FailDto failDto, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            String json = JSON.toJSONString(failDto);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
