package com.summer.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Account {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registerdate;
    private String address;
}
