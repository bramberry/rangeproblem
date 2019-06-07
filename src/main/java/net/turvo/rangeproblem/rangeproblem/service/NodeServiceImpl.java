package net.turvo.rangeproblem.rangeproblem.service;

import net.turvo.rangeproblem.rangeproblem.domain.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {
    @Override
    public List<Node> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Node getByName(String name) {
        return new Node();
    }
}
