package top.chuqin.utils.tools.restfulapidemo.web.exception.mapper;

import top.chuqin.utils.tools.restfulapidemo.exception.DuplicateOrgNameException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class DuplicateOrgNameExceptionMapper implements ExceptionMapper<DuplicateOrgNameException> {

    @Override
    public Response toResponse(DuplicateOrgNameException exception) {
        return Response.status(BAD_REQUEST.getStatusCode(), exception.getMessage()).build();
    }

}
