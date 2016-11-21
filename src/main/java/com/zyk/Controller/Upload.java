package com.zyk.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * @author zyk
 * @create 2016-10-21 14:27
 */
@WebServlet("/helloWorld")
public class Upload extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Upload.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            @SuppressWarnings("rawtypes")
            Iterator items;
            PrintWriter out = response.getWriter();
            try {
                items = upload.parseRequest(request).iterator();
                while (items.hasNext()) {
                    FileItem item = (FileItem) items.next();
                    if (!item.isFormField()) {
                        //取出上传文件的文件名称
                        String name = item.getName();
                        System.out.println(name);

                        String fileName = name.substring(name.lastIndexOf('\\') + 1, name.length());
                        System.out.println(fileName);

                        String path = "D:\\home\\www\\upload_test" + File.separatorChar + fileName;
                        System.out.println(path);
                        //上传文件 
                        File uploadedFile = new File(path);
                        if (!uploadedFile.exists()){
                            logger.info("create temp directory ["+uploadedFile.getParentFile()+"]");
                            System.out.println(uploadedFile.getAbsolutePath());
                            uploadedFile.getParentFile().mkdirs();
                        }
                        item.write(uploadedFile);
                        System.out.println(path);
                        out.print("<font size='2'>上传的文件为：" + name + "<br>");
                        out.print("保存的地址为：" + path + "</font>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.print("错误：" + e + "</font>");
            }
        }
    }
}
