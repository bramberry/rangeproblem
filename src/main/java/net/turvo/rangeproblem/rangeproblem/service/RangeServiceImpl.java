package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.turvo.rangeproblem.rangeproblem.model.Neighbor;
import net.turvo.rangeproblem.rangeproblem.model.Node;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeService;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.RangeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RangeServiceImpl implements RangeService {

    private final NodeService nodeService;

    /**
     * Searches for cities that can be reached
     *
     * @param city The name of city
     * @param time Time to reach the city
     * @return Set of cities
     */
    @Override
    @Cacheable("city-time-result")
    public Set<String> findCities(String city, Integer time) {
        Node node = nodeService.getByName(city)
                .orElseThrow(() -> new IllegalArgumentException("No such a city"));

        return getNodes(node, new HashSet<>(), time, 0);
    }

    /**
     * A recursive function, that starts for each reachable neighbor
     *
     * @param node        current node
     * @param visited     recently visited nodes
     * @param time        max time to rich a city
     * @param currentTime
     * @return Set of cities
     */
    private Set<String> getNodes(Node node, Set<String> visited, Integer time, Integer currentTime) {

        Set<String> res = new HashSet<>();

        visited.add(node.getCity());

        for (Neighbor neighbor : node.getNeighbors()) {
            if (visited.contains(neighbor.getName()) || currentTime + neighbor.getTime() > time) {
                continue;
            }
            res.add(neighbor.getName());
            nodeService.getByName(neighbor.getName()).ifPresent(next -> res.addAll(
                    getNodes(next, new HashSet<>(visited), time, currentTime + neighbor.getTime())));

        }
        return res;
    }

}
