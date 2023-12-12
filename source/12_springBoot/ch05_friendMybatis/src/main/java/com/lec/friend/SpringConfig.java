package com.lec.friend;

import com.lec.friend.repository.FriendRepository;
import com.lec.friend.service.FriendService;
import com.lec.friend.service.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private FriendRepository friendRepository; // 필드주입
  @Autowired // 생성자 주입(spring boot 3 부터는 생성자 주입을 주로 사용)
  public SpringConfig(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  @Bean
  public FriendService friendService() {
    return new FriendServiceImpl(friendRepository);
  }

}
