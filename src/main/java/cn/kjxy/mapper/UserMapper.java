package cn.kjxy.mapper;

import cn.kjxy.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
  UserEntity findUserByName(String name);
  UserEntity findUserById(Integer id);
  void deleteUser(Integer id);
  void updateUser(UserEntity user);
  List<UserEntity> getUsers(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
  Integer getUsersCount();
  void saveUser(UserEntity user);
}
