package com.summer.repository;


import com.summer.entity.Admin;
import org.apache.ibatis.annotations.Mapper;


public interface AdminRepository {
    public Admin login(String username, String password);
}
