package com.presio.memopad.response;

import java.util.List;

public class DeleteTreeResponse {
  private List<Integer> ids;

  public DeleteTreeResponse(List<Integer> ids) {
    this.ids = ids;
  }

  public List<Integer> getIds() {
    return ids;
  }

  public void setIds(List<Integer> ids) {
    this.ids = ids;
  }
}