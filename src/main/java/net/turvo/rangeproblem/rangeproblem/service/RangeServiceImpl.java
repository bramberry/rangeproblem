package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.turvo.rangeproblem.rangeproblem.model.Neighbor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.RangeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class RangeServiceImpl implements RangeService {

    private final NodeService nodeService;

    @Override
    @Cacheable("city-time-result")
    public Set<String> findCities(String city, Integer time) {

        Node node = nodeService.getByName(city);

        return getNodes(node, new ArrayList<>(), time, 0);
    }

    private Set<String> getNodes(Node node, List<String> visited, Integer time, Integer currentTime) {

        Set<String> res = new HashSet<>();

        visited.add(node.getCity());

        for (Neighbor neighbor : node.getNeighbors()) {
            if (visited.contains(neighbor.getName()) || currentTime + neighbor.getTime() > time) {
                continue;
            }
            res.add(neighbor.getName());
            Node next = nodeService.getByName(neighbor.getName());
            if (next == null) {
                continue;
            }

            res.addAll(getNodes(next, new ArrayList<>(visited), time, currentTime + neighbor.getTime()));
        }
        return res;
    }

}
