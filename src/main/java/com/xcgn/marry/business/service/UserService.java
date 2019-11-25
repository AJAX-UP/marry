package com.xcgn.marry.business.service;

import com.xcgn.marry.business.model.User;

public interface UserService {

    User findByUsername(String userName);

    User findByPhone(String phone);
}
