package net.turvo.rangeproblem.rangeproblem.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Neighbor implements Serializable {

    private Integer time;
    private String name;

    public Neighbor(Integer time, String name) {
        this.time = time;
        this.name = name;
    }
}
