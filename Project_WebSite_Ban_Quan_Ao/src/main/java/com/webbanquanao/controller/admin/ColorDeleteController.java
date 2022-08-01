package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.ColorService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.ColorServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/color/delete" })
public class ColorDeleteController extends HttpServlet {
    ColorService colorService = new ColorServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());

        String id = request.getParameter("id");
        colorService.delete(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/admin/color/list");
    }

}
