package com.lec.friend.domain;

import lombok.Data;

@Data
public class Friend {
  private Long id;
  private String name;
  private String tel;


  public Friend(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }
}
