package com.presio.memopad.response;

import java.util.List;
import java.util.stream.Collectors;
import com.presio.memopad.model.Node;
import com.presio.memopad.model.NodeResponse; // replace with the actual package of NodeResponse

public record TreeListenResponse(List<NodeResponse> nodes) {
  public static TreeListenResponse fromNodes(List<Node> nodes) {
    return new TreeListenResponse(nodes.stream().map(NodeResponse::new).collect(Collectors.toList()));
  }
}