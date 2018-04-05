package top.chuqin.utils.tools.restfulapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class RestfulApiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiDemoApplication.class, args);
    }

}
