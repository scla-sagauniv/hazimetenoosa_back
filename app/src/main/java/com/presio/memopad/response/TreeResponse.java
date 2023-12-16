package com.presio.memopad.response;

import com.presio.memopad.model.Node;

public record TreeResponse(Integer id, String title, String content) {
  public TreeResponse(Node node) {
    this(node.getId(), node.getTitle(), node.getContent());
  }
}

