package com.webbanquanao.controller.admin;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.BrandService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.BrandServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns= {"/admin/brand/list"})
public class BrandListController extends HttpServlet {
    BrandService brandService = new BrandServiceImpl();
    UserService userService =new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        List<BrandEntity> brandList = brandService.getAll();
        request.setAttribute("brandList", brandList);
        int role = user.getPermission();
        String link = "/View/admin/list-brand.jsp";
        if(role == 1){
            link = "/View/admin/list-brand.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }
}
