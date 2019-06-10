package net.turvo.rangeproblem.rangeproblem.controller;

import lombok.RequiredArgsConstructor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nodes")
@RequiredArgsConstructor
public class NodeController {

    private final NodeService nodeService;

    @PostMapping
    public ResponseEntity<Node> save(@RequestBody Node node) {
        return ResponseEntity.ok(nodeService.save(node));
    }

    @GetMapping
    public ResponseEntity<List<Node>> getNodes() {
        return ResponseEntity.ok(nodeService.findAll());
    }
}
