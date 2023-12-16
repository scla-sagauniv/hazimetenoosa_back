ALTER TABLE Nodes
ADD (
    author_id INT NOT NULL,
    INDEX auth_ind (author_id),
    FOREIGN KEY (author_id) REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE
  );