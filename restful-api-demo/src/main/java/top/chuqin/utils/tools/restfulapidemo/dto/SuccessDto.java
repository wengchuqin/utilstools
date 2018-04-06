package top.chuqin.utils.tools.restfulapidemo.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class SuccessDto {
    private boolean success;
    private String timestamp;
    private Object data;

    public SuccessDto() {
    }

    public SuccessDto(Object data) {
        success = true;
        timestamp = timestamp = LocalDateTime.now().toString();
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessDto that = (SuccessDto) o;
        return success == that.success &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(success, timestamp, data);
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "SuccessDto{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
