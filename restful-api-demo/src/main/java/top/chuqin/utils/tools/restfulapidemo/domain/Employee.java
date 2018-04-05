package top.chuqin.utils.tools.restfulapidemo.domain;

import java.util.Objects;

public class Employee {

    private Integer id;
    private String name;

    public Employee() {
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
        Employee employee = (Employee) o;
        return id == employee.id &&
                name == employee.name;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
