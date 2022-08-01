package com.webbanquanao.controller.admin;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.BrandService;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.BrandServiceImpl;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = { "/admin/brand/delete" })
public class BranDeleteController extends HttpServlet {
    BrandService brandService = new BrandServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        String id = request.getParameter("id");
        brandService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/admin/brand/list");
    }
}
