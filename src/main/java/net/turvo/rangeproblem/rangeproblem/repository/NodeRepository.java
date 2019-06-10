package net.turvo.rangeproblem.rangeproblem.repository;

import net.turvo.rangeproblem.rangeproblem.model.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends MongoRepository<Node, String> {
    Node findByCity(String city);
}
