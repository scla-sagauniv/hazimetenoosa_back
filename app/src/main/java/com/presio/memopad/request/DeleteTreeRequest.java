package com.presio.memopad.request;

import java.util.List;

public class DeleteTreeRequest {
  private List<Integer> ids;

  public List<Integer> getIds() {
    return ids;
  }

  public void setIds(List<Integer> ids) {
    this.ids = ids;
  }
}