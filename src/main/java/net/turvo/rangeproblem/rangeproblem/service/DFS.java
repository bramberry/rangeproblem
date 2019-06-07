package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import net.turvo.rangeproblem.rangeproblem.domain.Neighbor;
import net.turvo.rangeproblem.rangeproblem.domain.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DFS {

    private final NodeService nodeService;

    public List<Node> findCities(String city, Integer time) {

        Node node = nodeService.getByName(city);

        Deque<Node> nodes = new ArrayDeque<>();

        nodes.addFirst(node);

        return getNodes(nodes, new ArrayList<>(), time, 0);
    }

    private List<Node> getNodes(Deque<Node> deque, List<String> visited, Integer time, Integer currentTime) {

        List<Node> res = new ArrayList<>();

        Node node = deque.peekFirst();
        visited.add(node.getCity());


        for (Neighbor neighbor : node.getNeighbors()) {
            if (visited.contains(neighbor.getName())) {
                continue;
            }
            if (currentTime + neighbor.getTime() <= time) {
                Node next = nodeService.getByName(neighbor.getName());
                res.add(next);
                deque.addFirst(next);

                res.addAll(getNodes(deque, visited, time, time + neighbor.getTime()));
            }
        }

        return res;
    }


}
