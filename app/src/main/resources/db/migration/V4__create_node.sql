CREATE TABLE Nodes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  isSecret BOOLEAN NOT NULL,
  isFolder BOOLEAN NOT NULL,
  parentId INT,
  childrenIds TEXT,
  contentId INT NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deletedAt TIMESTAMP,
  INDEX par_ind (parentId),
  FOREIGN KEY (parentId) REFERENCES Nodes(id) ON DELETE CASCADE ON UPDATE CASCADE,
  INDEX cont_ind (contentId),
  FOREIGN KEY (contentId) REFERENCES Memos(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (contentId) REFERENCES Folders(id) ON DELETE CASCADE ON UPDATE CASCADE
);