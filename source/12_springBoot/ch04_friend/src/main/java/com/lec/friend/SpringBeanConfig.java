package com.lec.friend;

import com.lec.friend.repository.FriendRepository;
import com.lec.friend.repository.FriendRepositoryImpl;
import com.lec.friend.service.FriendService;
import com.lec.friend.service.FriendServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

  @Bean
  public FriendRepository friendRepository() {
    return new FriendRepositoryImpl();
  }

  @Bean
  public FriendService friendService() {
    return new FriendServiceImpl(friendRepository());
  }
}
