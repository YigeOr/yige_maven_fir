package com.zyk.serviceImpl;

import com.zyk.dao.UserDao;
import com.zyk.domain.User;
import com.zyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zyk
 * @create 2016-10-22 17:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User selectUserInfo(){
        return this.userDao.selectUserInfo();
    }

}