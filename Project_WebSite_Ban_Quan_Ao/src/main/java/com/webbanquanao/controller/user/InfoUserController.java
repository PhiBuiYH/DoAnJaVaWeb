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
                msg="T??n kh??ng ???????c ????? tr???ng";

            } else if (user.getAddress().equals("")){
                msg="?????a ch??? kh??ng ???????c ????? tr???ng";

            } else {
                msg="Thay ?????i th??ng tin th??nh c??ng";
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
                msgPass="Vui l??ng nh???p m???t kh???u";
            }
            else if (newPassword.equals("")) {
                msgPass="Vui l??ng nh???p m???t kh???u m???i";

            } else if (confirmPassword.equals("")) {
                msgPass="Vui l??ng nh???p m???t kh???u x??c nh???n";
            } else if (!user.getPassword().equals(oldPassword)) {
                msgPass="M???t kh???u kh??ng ch??nh x??c";
            } else if (!newPassword.equals(confirmPassword)){
                msgPass="M???t kh???u x??c nh???n kh??ng ch??nh x??c";
            } else {
                user.setPassword(newPassword);
                userService.edit(user);
                msgPass="Thay ?????i m???t kh???u th??nh c??ng";
            }
            req.setAttribute("user",user);
            req.setAttribute("msgPass",msgPass);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/info-user.jsp");
        dispatcher.forward(req, resp);
    }
}
