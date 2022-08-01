package com.webbanquanao.controller.admin;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.CartServiceImpl;
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

@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
    CartItemService cartItemService=new CartItemServiceImpl();
    CartService cartService=new CartServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());

        List<CartEntity> listCart = cartService.getAll();

        for(CartEntity cart : listCart) {
            List<CartitemEntity> lstCartItem = cartItemService.getByCartId(cart.getId());
            cart.setCartitemEntities(lstCartItem);
        }

        request.setAttribute("listCart",listCart);
        /*List<CartitemEntity> listCartItem =cartItemService.getAll();
        request.setAttribute("listCartItem", listCartItem);*/
        int role = user.getPermission();
        String link = "/View/admin/list-order.jsp";
        if(role == 1){
            link = "/View/admin/list-order.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }
}
