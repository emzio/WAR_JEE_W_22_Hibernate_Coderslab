package pl.coderslab.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class School {
    private String name;
    private int id;

    @Autowired
    public School() {
    }

    public School(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
