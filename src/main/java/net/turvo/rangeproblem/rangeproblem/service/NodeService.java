package net.turvo.rangeproblem.rangeproblem.service;

import net.turvo.rangeproblem.rangeproblem.domain.Node;

import java.util.List;

public interface NodeService {

    List<Node> findAll();

    Node getByName(String name);
}
