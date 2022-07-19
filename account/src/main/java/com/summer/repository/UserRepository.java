package com.summer.repository;



import com.summer.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserRepository {
    public User login(String username, String password);
    public User register(User user);
}
