package net.turvo.rangeproblem.rangeproblem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Node {

    @Id
    private String id;
    @Indexed(unique = true)
    private String city;
    private List<Neighbor> neighbors;
}
