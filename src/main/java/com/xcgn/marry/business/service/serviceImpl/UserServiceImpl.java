package com.xcgn.marry.business.service.serviceImpl;

import com.xcgn.marry.business.dao.UserMapper;
import com.xcgn.marry.business.model.User;
import com.xcgn.marry.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper  userMapper;
    @Override
    public User findByUsername(String userName) {
        return userMapper.findByUesrName(userName);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
