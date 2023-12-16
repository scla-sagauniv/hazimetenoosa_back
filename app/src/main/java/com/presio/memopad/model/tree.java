package com.presio.memopad.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "Nodes")
public class tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean isSecret;

    private Boolean isFolder;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private tree parent;

    private String childrenIds;

    private Integer contentId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<tree> children;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}