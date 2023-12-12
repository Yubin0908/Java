package com.lec.friend.service;

import com.lec.friend.domain.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
  public int join(Friend friend);
  public Optional<Friend> findOne(long id);
  public List<Friend> findFriends();
  public int deleteOne(long id);
}
