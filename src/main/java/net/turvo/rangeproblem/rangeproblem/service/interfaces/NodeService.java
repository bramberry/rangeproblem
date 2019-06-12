package net.turvo.rangeproblem.rangeproblem.service.interfaces;

import net.turvo.rangeproblem.rangeproblem.model.Node;

import java.util.List;
import java.util.Optional;

public interface NodeService {

    List<Node> findAll();

    Optional<Node> getByName(String name);

    Node save(Node node);
}
