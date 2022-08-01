package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = { "/member/cart/remove" })
public class CartItemRemove extends HttpServlet {
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");
        int pId = Integer.parseInt(req.getParameter("pId"));
        if (cartEntity != null) {
            List<CartitemEntity> listCartItem = cartEntity.getCartitemEntities();
            CartitemEntity cartitemEntity = listCartItem.get(pId);
            cartService.removeProduct(cartEntity,pId);
            cartItemService.delete(cartitemEntity);
            httpSession.setAttribute("cartEntity", cartEntity);
        }
        resp.sendRedirect(req.getContextPath() + "/member/cart");
    }
}