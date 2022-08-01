package com.webbanquanao.controller.admin;

import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns= {"/admin/size/list"})
public class SizeListController extends HttpServlet {
    SizeService sizeService = new SizeServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        List<SizeEntity> listSize = sizeService.getAll();
        request.setAttribute("listSize", listSize);
        int role = user.getPermission();
        String link = "/View/admin/list-size.jsp";
        if(role == 1){
            link = "/View/admin/list-size.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }
}
