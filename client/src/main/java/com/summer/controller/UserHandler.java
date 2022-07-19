package com.summer.controller;

import com.summer.entity.User;
import com.summer.entity.UserVO;
import com.summer.feign.OrderFeign;
import com.summer.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index,limit));
        return userVO;
    }

    @GetMapping("/count")
    @ResponseBody
    public int count(){
        return userFeign.count();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable("id")long id){
        return userFeign.findById(id);
    }

    @GetMapping("/redirect/{location}")
    @ResponseBody
    public String redirect(@PathVariable("location") String location){return location;}

    @PutMapping("/update")
    public String update(@RequestBody User user){
        userFeign.update(user);
        return "redirect:/user/redirect/user_manage";
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        orderFeign.deleteByUid(id);
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}
