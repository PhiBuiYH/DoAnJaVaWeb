package com.webbanquanao.controller.admin;

import clojure.lang.Compiler;
import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/color/add"})
public class ColorAddController extends HttpServlet {

    ColorService colorService = new ColorServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());

        int role = user.getPermission();
        String link = "/View/admin/add-color.jsp";
        if(role == 1){
            link = "/View/admin/add-color.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ColorEntity colorEntity = new ColorEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {

            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("color")) {
                    colorEntity.setColorName(item.getString());
                }
            }

            colorService.insert(colorEntity);
            response.sendRedirect(request.getContextPath() + "/admin/color/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Two");
            response.sendRedirect(request.getContextPath() + "/admin/product/add?e=1");
        }

    }
}
