package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.turvo.rangeproblem.rangeproblem.model.Neighbor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.model.NodeCacheResults;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeCacheService;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.RangeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class RangeServiceImpl implements RangeService {

    private final NodeService nodeService;
    private final NodeCacheService nodeCacheService;

    @Override
    public Set<String> findCities(String city, Integer time) {
        NodeCacheResults nodeCacheResults = nodeCacheService.getByCity(city);
        if (nodeCacheResults != null) {
            log.info("result from cache");
            return nodeCacheResults.getReachableCities();
        }

        Node node = nodeService.getByName(city);

        Set<String> res = getNodes(node, new ArrayList<>(), time, 0);

        cacheResults(city, time, res);
        return res;
    }

    private Set<String> getNodes(Node node, List<String> visited, Integer time, Integer currentTime) {

        Set<String> res = new HashSet<>();

        visited.add(node.getCity());
        log.info("visited: {}", visited);

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

    private void cacheResults(String city, Integer time, Set<String> reachableCites) {
        NodeCacheResults nodeCacheResults = new NodeCacheResults();
        nodeCacheResults.setId(city);
        nodeCacheResults.setMaxCalculatedTime(time);
        nodeCacheResults.setReachableCities(reachableCites);
        nodeCacheService.save(nodeCacheResults);
    }
}
