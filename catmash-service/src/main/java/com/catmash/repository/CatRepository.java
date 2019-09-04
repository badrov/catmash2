package com.catmash.repository;

import com.catmash.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, String> {
    @Query(value = "SELECT * FROM Cat ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Cat> getCatsRandom(@Param("count")  int count);
}
