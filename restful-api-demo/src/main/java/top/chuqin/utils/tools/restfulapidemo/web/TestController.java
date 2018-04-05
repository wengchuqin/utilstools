package top.chuqin.utils.tools.restfulapidemo.web;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class TestController {

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam @NotNull @Length(min = 1, max = 10) String name,
                           @RequestParam @NotNull @Max(value = 150) Integer age){
        return String.format("hello, your name is %s, your age is %s.", name, age);
    }

}
