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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/infoController")
public class InfoUserController  extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email=(String) session.getAttribute("email");
        if(email!=null) {
            UserEntity user = userService.getUser(email);

            List<CartEntity> carts = cartService.getByUserId(user.getId());

            if (carts != null) {
                for (CartEntity cart : carts) {
                    List<CartitemEntity> lstCartItem = cartItemService.getByCartId(cart.getId());
                    cart.setCartitemEntities(lstCartItem);
                }
            }

            req.setAttribute("carts", carts);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/info-user.jsp");
            dispatcher.forward(req, resp);
        }
        else
        {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Home");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("changeInfo")) {
            String msg="";
            String url="";
            HttpSession session = req.getSession();
            String email=(String) session.getAttribute("email");
            UserEntity user = userService.getUser(email);
            String address = req.getParameter("address");
            String name = req.getParameter("name");
            user.setAddress(address);
            user.setUserName(name);
            if (user.getUserName().equals("")){
                msg="Tên không được để trống";

            } else if (user.getAddress().equals("")){
                msg="Địa chỉ không được để trống";

            } else {
                msg="Thay đổi thông tin thành công";
                userService.edit(user);
            }
            req.setAttribute("user",user);
            req.setAttribute("msg",msg);
        } else if (type.equals("changePassword")) {
            String msgPass="";
            HttpSession session = req.getSession();
            String email=(String) session.getAttribute("email");
            UserEntity user = userService.getUser(email);

            String oldPassword = req.getParameter("oldPassword");
            String newPassword = req.getParameter("newPassword");
            String confirmPassword = req.getParameter("confirmPassword");
            if(oldPassword.equals("")) {
                msgPass="Vui lòng nhập mật khẩu";
            }
            else if (newPassword.equals("")) {
                msgPass="Vui lòng nhập mật khẩu mới";

            } else if (confirmPassword.equals("")) {
                msgPass="Vui lòng nhập mật khẩu xác nhận";
            } else if (!user.getPassword().equals(oldPassword)) {
                msgPass="Mật khẩu không chính xác";
            } else if (!newPassword.equals(confirmPassword)){
                msgPass="Mật khẩu xác nhận không chính xác";
            } else {
                user.setPassword(newPassword);
                userService.edit(user);
                msgPass="Thay đổi mật khẩu thành công";
            }
            req.setAttribute("user",user);
            req.setAttribute("msgPass",msgPass);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/info-user.jsp");
        dispatcher.forward(req, resp);
    }
}
