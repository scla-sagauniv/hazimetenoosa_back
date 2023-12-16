package com.presio.memopad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.presio.memopad.service.NodeService;
import com.presio.memopad.model.Node;

@RestController
public class TreeController {

  @Autowired
  private NodeService nodeService;

  @GetMapping("/tree")
  public ResponseEntity<List<Node>> getTree() {
    List<Node> tree = nodeService.getTree();
    return ResponseEntity.ok(tree);
  }

  @PostMapping("/tree")
  public ResponseEntity<Node> createNode(@RequestBody Node node) {
      Node createdNode = nodeService.createNode(node);
      return ResponseEntity.ok(createdNode);
  }

  @PutMapping("/tree")
  public ResponseEntity<Node> updateTree(@RequestBody List<Node> tree) {
    Node updatedTree = nodeService.updateTree(tree);
    return ResponseEntity.ok(updatedTree);
  }

  @DeleteMapping("/tree")
  public ResponseEntity<Void> deleteTree(@RequestBody List<Integer> ids) {
    nodeService.deleteTree(ids);
    return ResponseEntity.noContent().build();
  }
}