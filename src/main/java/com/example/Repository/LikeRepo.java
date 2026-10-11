package com.example.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepo extends ReactiveCrudRepository<LikeRepo,Long> {
}
