package net.turvo.rangeproblem.rangeproblem.service;

import lombok.RequiredArgsConstructor;
import net.turvo.rangeproblem.rangeproblem.model.NodeCacheResults;
import net.turvo.rangeproblem.rangeproblem.repository.NodeCacheRepository;
import net.turvo.rangeproblem.rangeproblem.service.interfaces.NodeCacheService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NodeCacheServiceImpl implements NodeCacheService {
    private final NodeCacheRepository nodeCacheRepository;

    @Override
    public NodeCacheResults save(NodeCacheResults nodeCacheResults) {
        return nodeCacheRepository.save(nodeCacheResults);
    }

    @Override
    public NodeCacheResults getByCity(String id) {
        return nodeCacheRepository.findById(id).orElse(null);
    }
}
