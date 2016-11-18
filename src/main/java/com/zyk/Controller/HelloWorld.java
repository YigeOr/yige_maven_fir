package com.zyk.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zyk.domain.User;
import com.zyk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaoyunkang
 * @create 2016-10-21 14:27
 */
@WebServlet("/helloWorld")
public class HelloWorld extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        try {
            user = userService.selectUserInfo();
            logger.info(JSONObject.toJSONString(user));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
//        PrintWriter out = resp.getWriter();
//        out.println(s);

        String name = req.getParameter("name");
        String student = user.getStudentName();
        req.setAttribute("name", name);
        req.setAttribute("student", student);
        System.out.println(name);
        System.out.println(student);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
