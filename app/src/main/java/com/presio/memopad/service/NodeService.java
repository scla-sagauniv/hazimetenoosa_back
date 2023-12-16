package com.presio.memopad.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.presio.memopad.model.Node;
import com.presio.memopad.repository.NodeRepository;

@Service
public class NodeService {
  
  @Autowired
  private NodeRepository nodeRepository;
  
  public List<Node> getTree() {
    List<Node> allNodes = nodeRepository.findAll();
    Map<Integer, List<Node>> childNodesMap = new HashMap<>();
    
    for (Node node : allNodes) {
      if (node.getParentId() != null) {
        childNodesMap.computeIfAbsent(node.getParentId(), k -> new ArrayList<>()).add(node);
      }
    }
    
    List<Node> rootNodes = allNodes.stream()
    .filter(node -> node.getParentId() == null)
    .collect(Collectors.toList());
    
    for (Node rootNode : rootNodes) {
      addChildren(rootNode, childNodesMap);
    }
    
    return rootNodes;
  }
  
  private void addChildren(Node node, Map<Integer, List<Node>> childNodesMap) {
    List<Node> childNodes = childNodesMap.get(node.getId());
    if (childNodes != null) {
      for (Node childNode : childNodes) {
        addChildren(childNode, childNodesMap);
      }
      node.setChildren(childNodes);
    }
  }
  
  public Node createNode(Node node) {
    Node savedNode = nodeRepository.save(node);
    return savedNode;
  }
  
  public Node updateTree(List<Node> tree) {
    Node rootNode = null;
    if (!tree.isEmpty()) {
        rootNode = tree.get(0); // Set the first node as root
        for (Node node : tree) {
            // Update each node in the tree
            nodeRepository.save(node);
        }
    }
    return rootNode;
  }

  public void deleteTree(List<Integer> ids) {
    for(Integer id : ids) {
      nodeRepository.deleteById(id);
    }
  }
}