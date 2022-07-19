package com.summer.repository;

import com.summer.entity.User;

import java.util.List;


public interface UserRepository {
    public List<User> findAll(int index, int limit);
    public int count();
    public User findById(long id);
    public void save(User user);
    public void deleteById(long id);
    public void update(User user);
}
