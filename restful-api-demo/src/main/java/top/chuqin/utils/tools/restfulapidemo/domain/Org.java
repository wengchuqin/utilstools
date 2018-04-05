package top.chuqin.utils.tools.restfulapidemo.domain;

import java.util.Objects;

public class Org {

    private Integer id;
    private String name;

    public Org() {
    }

    public Org(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Org(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Org org = (Org) o;
        return id == org.id &&
                name == org.name;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
