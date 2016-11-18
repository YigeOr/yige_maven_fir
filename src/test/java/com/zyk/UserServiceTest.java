package com.zyk;

import com.alibaba.fastjson.JSONObject;
import com.zyk.domain.User;
import com.zyk.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author zhaoyunkang
 * @create 2016-10-22 17:14
 */
public class UserServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void userServiceTest(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)context.getBean("userService");
        try {
            User user = userService.selectUserInfo();
            System.out.println(JSONObject.toJSONString(user));
            logger.info(JSONObject.toJSONString(user));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}