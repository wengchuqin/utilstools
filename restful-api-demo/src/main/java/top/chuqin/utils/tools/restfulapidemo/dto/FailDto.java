package top.chuqin.utils.tools.restfulapidemo.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class FailDto {
    private boolean success;
    private String timestamp;
    private long code;
    private String message;
    private String desciption;


    public FailDto() {
        success = false;
        timestamp = LocalDateTime.now().toString();
    }


    public void setCode(long code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDesciption() {
        return desciption;
    }
}
