package net.turvo.rangeproblem.rangeproblem.service.interfaces;

import net.turvo.rangeproblem.rangeproblem.model.Node;

import java.util.List;

public interface NodeService {

    List<Node> findAll();

    Node getByName(String name);

    Node save(Node node);

    Node update(Node node);
}
