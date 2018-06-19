package top.chuqin.utils.tools.springaop;

import org.springframework.stereotype.Service;

@Service
@AspectAction
public class PeopleService {

    @AspectAction
    public void add(){
        System.out.println("add People");
    }


    public void delete(){
        System.out.println("delete People");
    }
}
