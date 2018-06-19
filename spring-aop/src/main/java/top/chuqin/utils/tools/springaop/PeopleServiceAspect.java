package top.chuqin.utils.tools.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PeopleServiceAspect {

    /*
     * 命中@AspectAction标注的方法
     */
    @Pointcut("@annotation(top.chuqin.utils.tools.springaop.AspectAction)")
    public void point1(){ }

    /*
     * 命中@AspectAction标注的类中的所有方法
     */
    @Pointcut("@within(top.chuqin.utils.tools.springaop.AspectAction)")
    public void point2(){ }


    @Before("point1()||point2()")
    public void before(JoinPoint joinPoint){
        System.out.println("before... ");
    }

}
