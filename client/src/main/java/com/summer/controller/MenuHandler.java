package com.summer.controller;

import com.summer.entity.Menu;
import com.summer.entity.MenuVO;
import com.summer.entity.Type;
import com.summer.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@PathVariable("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        MenuVO menuVO = menuFeign.findAll(index,limit);
        return menuVO;
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){return location;}

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findTypes")
    @ResponseBody
    public List<Type> findTypes(){
        return menuFeign.findTypes();
    }

    @PostMapping("/save")
    public String save(@RequestBody Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public Menu findById(@PathVariable("id")long id){
        return menuFeign.findById(id);
    }

    @PutMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }
}
