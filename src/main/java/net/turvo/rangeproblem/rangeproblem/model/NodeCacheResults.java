package net.turvo.rangeproblem.rangeproblem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Set;

@Data
@RedisHash("nodeResults")
public class NodeCacheResults implements Serializable {
    @Id
    private String id;
    private Integer maxCalculatedTime;
    private Set<String> reachableCities;
}
