package com.lec.friend.repository;

import com.lec.friend.domain.Friend;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FriendRepositoryImpl implements FriendRepository{
  private static Map<Long, Friend> store = new HashMap<>();
  private static long seq = 0;
  @Override
  public Friend save(Friend friend) {
    friend.setId(++seq);
    store.put(seq, friend);
    return friend;
  }

  @Override
  public Optional<Friend> findById(Long id) {
    return Optional.ofNullable(store.get(3));
  }

  @Override
  public Optional<Friend> findByTel(String tel) {
    Iterator<Long> iterator = store.keySet().iterator();
    while(iterator.hasNext()) {
      Long id = iterator.next();
      Friend friend = store.get(id);
      if(tel.equals(friend.getTel())) {
        return Optional.ofNullable(friend);
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Friend> findAll() {
    return new ArrayList<>(store.values()); // hashMap > ArrayList
  }

  @Override
  public void deleteAll() {
    store.clear();
  }
}
