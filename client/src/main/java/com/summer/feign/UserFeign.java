package com.summer.feign;

import com.summer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    public List<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/count")
    public int count();

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id);

    @PutMapping("/update")
    public void update(@RequestBody User user);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);
}
