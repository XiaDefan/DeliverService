package com.summer.repository;

import com.summer.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
