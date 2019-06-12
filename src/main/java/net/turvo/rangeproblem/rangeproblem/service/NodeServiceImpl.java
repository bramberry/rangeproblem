package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.repository.NodeRepository;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NodeServiceImpl implements NodeService {

    private final NodeRepository nodeRepository;

    @Override
    public List<Node> findAll() {
        return nodeRepository.findAll();
    }

    @Override
    public Optional<Node> getByName(String name) {
        return nodeRepository.findByCity(name);
    }

    @Override
    public Node save(Node node) {
        return nodeRepository.save(node);
    }

}
