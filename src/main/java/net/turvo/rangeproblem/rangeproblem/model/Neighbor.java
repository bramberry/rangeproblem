package net.turvo.rangeproblem.rangeproblem.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Neighbor implements Serializable {

    private Integer time;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
