package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
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
import java.sql.Date;
import java.util.Map;
import java.util.UUID;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();
    long time = System.currentTimeMillis();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        UserEntity buyer = (UserEntity) obj;
        CartEntity cart = new CartEntity();
        cart.setUserEntity(buyer);
        cart.setBuyDate(new Date(time));
 //       cart.setId(RandomUUID.getRandomID());
        cartService.insert(cart);

        Object objCart = session.getAttribute("cart");
        if (objCart != null) {
            // ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
            Map<Integer, CartitemEntity> map = (Map<Integer, CartitemEntity>) objCart;

            for (CartitemEntity cartItem : map.values()) {
                cartItem.setCartEntity(cart);
//                cartItem.setId(RandomUUID.getRandomID());
//                SendMail sm = new SendMail();
//                sm.sendMail(cart.getUserEntity().getEmail(), "UNIFY", "Payment success. We will contact you soon ! ");
                cartItemService.insert(cartItem);

            }
        }

        session.removeAttribute("cart");
        resp.sendRedirect(req.getContextPath() + "/home");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}