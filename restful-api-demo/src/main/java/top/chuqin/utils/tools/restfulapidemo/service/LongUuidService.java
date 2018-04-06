package top.chuqin.utils.tools.restfulapidemo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Validated
public class LongUuidService {
    private AtomicLong atomicLong = new AtomicLong(1);

    public long genUuid(){
        return atomicLong.incrementAndGet();
    }

}
