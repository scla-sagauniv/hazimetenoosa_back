ALTER TABLE Users
  rename column authInfo to auth_info;
ALTER TABLE Users
  rename column createdAt to created_at;
ALTER TABLE Users
  rename column updatedAt to updated_at;
ALTER TABLE Users
  rename column deletedAt to deleted_at;