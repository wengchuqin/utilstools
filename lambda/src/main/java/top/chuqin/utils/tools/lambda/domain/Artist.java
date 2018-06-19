package top.chuqin.utils.tools.lambda.domain;

import java.util.Objects;

public class Artist {
    private String name;
    private String members;
    private String origin;

    public Artist() {
    }


    public Integer count(){
        return 5;
    }

    public Boolean isFrom(String local){
        return Objects.equals(local, origin);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
