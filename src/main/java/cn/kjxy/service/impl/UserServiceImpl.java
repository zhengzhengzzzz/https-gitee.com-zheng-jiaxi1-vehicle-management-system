package cn.kjxy.service.impl;

import cn.kjxy.entity.UserEntity;
import cn.kjxy.mapper.UserMapper;
import cn.kjxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity user = userMapper.findUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with username："+username);
        }
        return new LoginUser(user, (List<GrantedAuthority>) getAuthorities(user.getRole()));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); // 根据实际角色创建权限对象
        return authorities;
    }
    @Override
    public UserEntity findUserByName(String username) {return userMapper.findUserByName(username);}
    @Override
    public UserEntity findUserById(Integer id){return userMapper.findUserById(id);}

    @Override
    public void deleteUser(Integer id){userMapper.deleteUser(id);}
    @Override
    public void updateUser(UserEntity user){userMapper.updateUser(user);}
    @Override
    public List<UserEntity> getUsers(Integer pageNum,Integer pageSize){
        if(pageNum == 1){
            pageNum = 0;
        }
        return userMapper.getUsers(pageNum,pageSize);
    }
    @Override
    public Integer getUserCount(){return userMapper.getUsersCount();}
    @Override
    public void saveUser(UserEntity user){userMapper.saveUser(user);}
}
