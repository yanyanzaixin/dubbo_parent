package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
       return "hello zookeeper";
    }
}
