ALTER TABLE Nodes
  rename column isSecret to is_secret;
ALTER TABLE Nodes
  rename column isFolder to is_folder;
ALTER TABLE Nodes
  rename column parentId to parent_id;
ALTER TABLE Nodes
  rename column childrenIds to children_ids;
ALTER TABLE Nodes
  rename column contentId to content_id;
ALTER TABLE Nodes
  rename column createdAt to created_at;
ALTER TABLE Nodes
  rename column updatedAt to updated_at;
ALTER TABLE Nodes
  rename column deletedAt to deleted_at;