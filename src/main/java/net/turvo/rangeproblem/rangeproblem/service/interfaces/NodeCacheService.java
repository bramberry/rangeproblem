package net.turvo.rangeproblem.rangeproblem.service.interfaces;

import net.turvo.rangeproblem.rangeproblem.model.NodeCacheResults;

public interface NodeCacheService {
    NodeCacheResults save(NodeCacheResults nodeCacheResults);

    NodeCacheResults getByCity(String id);
}
