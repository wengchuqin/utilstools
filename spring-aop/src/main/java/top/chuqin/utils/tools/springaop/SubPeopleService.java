package top.chuqin.utils.tools.springaop;

import org.springframework.stereotype.Service;

@Service
public class SubPeopleService extends PeopleService{
    public void update(){
        System.out.println("update People");
    }
}
