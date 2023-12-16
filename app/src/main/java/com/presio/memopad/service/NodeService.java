package com.presio.memopad.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.presio.memopad.model.Node;
import com.presio.memopad.repository.NodeRepository;
import com.presio.memopad.error.ResourceNotFoundException;

@Service
public class NodeService {

  @Autowired
  private NodeRepository nodeRepository;

  public List<Node> getAllNodes() {
    return nodeRepository.findAll();
  }
  
  public Node createNode(Node node) {
    // Implement your logic to create a node here.
    // This might involve saving the node to a database, for example.
    // For now, let's just return the node that was passed in.
    return node;
  }

  public Node updateNode(Integer id, Node nodeData) {
    Node node = nodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Node", "id", id));
    node.setTitle(nodeData.getTitle());
    node.setContent(nodeData.getContent());
  
    return nodeRepository.save(node);
  }

  public void deleteNode(Integer id) {
    if(nodeRepository.existsById(id)) {
        nodeRepository.deleteById(id);
    } else {
        throw new ResourceNotFoundException("Node", "id", id);
    }
  }
}