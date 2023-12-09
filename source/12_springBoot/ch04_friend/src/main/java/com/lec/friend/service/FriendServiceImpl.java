package com.lec.friend.service;

import com.lec.friend.domain.Friend;
import com.lec.friend.repository.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service
@Slf4j
public class FriendServiceImpl implements FriendService{

  private FriendRepository repository;

  // @Autowired
  public FriendServiceImpl(FriendRepository repository) {
    this.repository = repository;
  }

  @Override
  public void join(Friend friend) { // 요구사항 : 중복된 전화번호 저장 안됨
    validateDuplicateFriendTel(friend);
    repository.save(friend); // 종복되지 않은 전화번호를 저장할 때
  }

  private void validateDuplicateFriendTel(Friend friend) {
    Optional<Friend> result = repository.findByTel(friend.getTel());
    result.ifPresent(friend1 -> { // 중복된 전화변호 저장할 때
      throw new IllegalStateException("이미 존재하는 친구입니다.");
    });
  }

  @Override
  public Optional<Friend> findOne(long id) {
    return repository.findById(id);
  }

  @Override
  public List<Friend> findFriends() {
    return repository.findAll();
  }
}
