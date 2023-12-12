package com.lec.friend.repository;

import com.lec.friend.domain.Friend;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Test 데이터를 db에 저장하지 않음
class FriendRepositoryTest {

  @Autowired
  private FriendRepository friendRepository;

  @Test
  void saveAndFindByTel() {
    Friend friend = new Friend("홍길동", "010-9999-9999");
    friendRepository.save(friend);
    Friend resultTel = friendRepository.findByTel(friend.getTel()).get();
    Friend resultId = friendRepository.findById(resultTel.getId()).get();
    assertThat(resultId).isEqualTo(resultTel);
    System.out.println("save & findByTel Test PASS!!");
  }

  @Test
  void findAll() {
    Friend friend1 = new Friend("홍길동", "010-1234-1234");
    Friend friend2 = new Friend("신길동", "010-5678-5678");
    friendRepository.save(friend1);
    friendRepository.save(friend2);
    List<Friend> friends = friendRepository.findAll();
    assertThat(friends.size()).isEqualTo(2);
    assertThat(friends.get(0).getName()).isEqualTo(friend1.getName());
    assertThat(friends.get(1).getTel()).isEqualTo(friend2.getTel());
    System.out.println("findAll Test PASS!!");
  }

  @Test
  void findByIdAndfindByTel() {
    Friend friend = new Friend("홍길동", "010-1111-1111");
    friendRepository.save(friend);
    Friend result1 = friendRepository.findByTel(friend.getTel()).get();
    Friend result2 = friendRepository.findById(result1.getId()).get();
    assertThat(result1).isEqualTo(result2);
    System.out.println("findByIdAndfindByTel Test PASS!!");
  }

  @Test
  void deleteOne() {
    Friend friend = new Friend("홍길동", "010-1234-1234");
    friendRepository.save(friend);
    Friend deleteFriend = friendRepository.findByTel(friend.getTel()).get();
    friendRepository.deleteOne(deleteFriend.getId());
    List<Friend> friends = friendRepository.findAll();
    assertThat(friends.size()).isEqualTo(0);
    System.out.println("deleteOne Test PASS!!");
  }
}