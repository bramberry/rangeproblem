package net.turvo.rangeproblem.rangeproblem.controller;

import lombok.RequiredArgsConstructor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nodes")
@RequiredArgsConstructor
public class NodeController {

    private final NodeService nodeService;

    @PostMapping
    public Node save(@RequestBody Node node) {
        return nodeService.save(node);
    }

    @GetMapping
    public List<Node> getNodes() {
        return nodeService.findAll();
    }
}
