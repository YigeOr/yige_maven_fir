package com.zyk.daoImpl;

import com.zyk.dao.UserDao;
import com.zyk.domain.User;
import com.zyk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyk
 * @create 2016-10-22 17:11
 */
@Service("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public User selectUserInfo(){
        return this.userMapper.selectUserInfo();
    }


}
