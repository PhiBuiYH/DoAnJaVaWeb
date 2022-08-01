package com.webbanquanao.controller.admin;


import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.CartServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/admin/order/update")
public class OrderUpdateController extends HttpServlet {
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService=new CartItemServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        req.setAttribute("user",user.getUserName());

        int id= Integer.parseInt(req.getParameter("id")) ;
        CartEntity cart = cartService.get(id);
        cartService.updateStatus(cart);

        resp.sendRedirect(req.getContextPath()+"/admin/order/list");

    }
}
