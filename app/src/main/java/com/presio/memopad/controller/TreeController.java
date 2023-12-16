package com.presio.memopad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.presio.memopad.service.NodeService;
import com.presio.memopad.model.Node;

@RestController
public class TreeController {

  @Autowired
  private NodeService nodeService;

  @GetMapping("/nodes")
  public List<Node> getNodes() {
    return nodeService.getAllNodes();
  }

  @PostMapping("/nodes")
  public ResponseEntity<Node> createNode(@RequestBody Node node) {
    Node createdNode = nodeService.createNode(node);
    return ResponseEntity.ok(createdNode);
  }

  @PutMapping("/nodes/{id}")
  public ResponseEntity<Node> updateNode(@PathVariable Integer id, @RequestBody Node node) {
    Node updatedNode = nodeService.updateNode(id, node);
    return ResponseEntity.ok(updatedNode);
  }

  @DeleteMapping("/nodes/{id}")
  public ResponseEntity<Void> deleteNode(@PathVariable Integer id) {
    nodeService.deleteNode(id);
    return ResponseEntity.noContent().build();
  }
}