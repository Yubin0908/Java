package com.lec.friend.repository;

import com.lec.friend.domain.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
@Mapper
public interface FriendRepository {
  @Insert("INSERT INTO FRIEND VALUES(FRIEND_ID_SQ.NEXTVAL, #{name}, #{tel})")
  public int save(Friend friend);
  @Select("SELECT * FROM FRIEND WHERE TEL = #{tel}")
  public Optional<Friend> findByTel(@Param("tel") String tel);
  @Select("SELECT * FROM FRIEND")
  public List<Friend> findAll();
  @Select("SELECT * FROM FRIEND WHERE ID = #{id}")
  public Optional<Friend> findById(@Param("id") long id);
  @Delete("DELETE FROM FRIEND")
  public int deleteAll();
  @Delete("DELETE FROM FRIEND WHERE ID = #{id}")
  public int deleteOne(@Param("id") long id);

}
