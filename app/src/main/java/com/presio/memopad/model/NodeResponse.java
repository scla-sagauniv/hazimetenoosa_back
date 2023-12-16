package com.presio.memopad.model;

public class NodeResponse {
    private Node node;

    public NodeResponse(Node node) {
        this.node = node;
    }


    public Node getNode() {
        return this.node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}