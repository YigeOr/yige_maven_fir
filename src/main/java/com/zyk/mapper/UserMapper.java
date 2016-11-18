package com.zyk.mapper;

import com.zyk.domain.User;
import org.springframework.stereotype.Service;


/**
 * @author zhaoyunkang
 * @create 2016-10-22 17:12
 */
@Service("userMapper")
public interface UserMapper {

    User selectUserInfo();

}
