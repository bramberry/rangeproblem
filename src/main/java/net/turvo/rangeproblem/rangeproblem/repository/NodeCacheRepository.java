package net.turvo.rangeproblem.rangeproblem.repository;

import net.turvo.rangeproblem.rangeproblem.model.NodeCacheResults;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeCacheRepository extends CrudRepository<NodeCacheResults, String> {
}
