package com.lec.friend.service;

import com.lec.friend.domain.Friend;
import com.lec.friend.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service
public class FriendServiceImpl implements FriendService{

  private FriendRepository friendRepository;
  // @Autowired
  public FriendServiceImpl(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  @Override
  public int join(Friend friend) {
    // 중복된 전화변호 저장 안됨.
    Optional<Friend> result = friendRepository.findByTel(friend.getTel());
    validateDuplicateFriendTel(friend);
    return friendRepository.save(friend);
  }

  private void validateDuplicateFriendTel(Friend friend) {
    friendRepository.findByTel(friend.getTel()).ifPresent(friend1 -> {
      throw new IllegalStateException("이미 존재하는 친구입니다.");
    });
  }
  @Override
  public Optional<Friend> findOne(long id) {
    return friendRepository.findById(id);
  }

  @Override
  public List<Friend> findFriends() {
    return friendRepository.findAll();
  }

  @Override
  public int deleteOne(long id) {
    return friendRepository.deleteOne(id);
  }
}
