package cn.kjxy.service;

import cn.kjxy.entity.UserEntity;
import cn.kjxy.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDetails loadUserByUsername(String username);
    UserEntity findUserByName(String name);
    UserEntity findUserById(Integer id);
    void deleteUser(Integer id);
    void updateUser(UserEntity user);
    List<UserEntity> getUsers(Integer pageNum, Integer pageSize);
    Integer getUserCount();
    void saveUser(UserEntity user);
}
