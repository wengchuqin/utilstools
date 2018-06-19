package top.chuqin.utils.tools.springaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private SubPeopleService subPeopleService;

    @Test
    public void add() {
        peopleService.add();
    }

    @Test
    public void delete() {
        peopleService.delete();
    }

    @Test
    public void update() {
        subPeopleService.update();
    }
}
