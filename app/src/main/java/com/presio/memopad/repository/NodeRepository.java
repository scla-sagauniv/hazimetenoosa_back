package com.presio.memopad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.presio.memopad.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {
    List<Node> findByParentId(Integer parentId);
}