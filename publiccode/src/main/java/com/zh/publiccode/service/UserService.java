package com.zh.publiccode.service;

import com.zh.publiccode.entity.User;

public interface UserService {

    String loginUser(User user);

    User getUserInfo(String id);
}
