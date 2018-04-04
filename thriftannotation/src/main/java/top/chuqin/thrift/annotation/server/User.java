package top.chuqin.thrift.annotation.server;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

import java.util.Objects;

@ThriftStruct
public class User {
    private String name;
    private String email;


    @ThriftField
    public String getName() {
        return name;
    }

    @ThriftField(1)
    public void setName(String name) {
        this.name = name;
    }

    @ThriftField
    public String getEmail() {
        return email;
    }

    @ThriftField(2)
    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email);
    }
}
