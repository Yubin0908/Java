package com.lec.friend.service;

import com.lec.friend.domain.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {

  public void join(Friend friend);
  public Optional<Friend> findOne(long id);
  public List<Friend> findFriends();

}
