package com.presio.memopad.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Nodes")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title; // Added title field

    private Boolean isSecret;

    private Boolean isFolder;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Integer parentId;

    private String childrenIds;

    private Integer contentId;

    private String content; // Added content field

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Node> children;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public String getTitle() { // Added getTitle method
        return this.title;
    }

    public String getContent() { // Added getContent method
        return this.content;
    }

    public void setContent(String content) { // Added setContent method
        this.content = content;
    }

    public void setParent(Node parent) {
        this.parentId = parent.getId();
    }
    
    public void addChild(Node child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
        child.setParentId(this.id);
    }
}