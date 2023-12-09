package com.lec.friend.service;

import com.lec.friend.domain.Friend;
import com.lec.friend.repository.FriendRepository;
import com.lec.friend.repository.FriendRepositoryImpl;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FriendServiceImplTest {

  @BeforeEach
  public void beforeEach() {
    repository.deleteAll();
  }
  // private FriendRepository repository = new FriendRepositoryImpl();
  // private FriendService friendService = new FriendServiceImpl(repository);
  @Autowired
  private FriendRepository repository;
  @Autowired
  private FriendService service;
  @Test
  void 중복되지않은친구등록() {
    Friend friend = new Friend("홍길동", "010-0000-0000");
    service.join(friend);
    List<Friend> friends = service.findFriends();
    Friend result = null;
    for(Friend f : friends) {
      if(f.getTel().equals(friend.getTel())) {
        result = f;
      }
    }
    Assertions.assertThat(friend).isEqualTo(result);
    System.out.println("중복되지 않은 전화번호 친구등록 테스트 완료.");
  }
  
  @Test
  void 중복된친구등록() {
    Friend friend1 = new Friend("홍길동", "010-1111-1111");
    Friend friend2 = new Friend("신길동", "010-1111-1111");
    service.join(friend1);
    try {
      service.join(friend2);
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 친구입니다.");
      System.out.println("중복된 전화번호 등록 테스트 완료.");
    }
  }
  /*@Test
  void findOne() {
    Friend friend = new Friend("홍길동", "010-9999-9999");
    service.join(friend);
    Friend result = service.findOne(friend.getId()).get();
    assertThat(friend.getName()).isEqualTo(result.getName());
    assertThat(friend.getTel()).isEqualTo(result.getTel());
    System.out.println("findOne 테스트 완료.");
  }*/
}




