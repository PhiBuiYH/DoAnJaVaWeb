package com.webbanquanao.controller.user;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.UserServiceImpl;
import com.webbanquanao.utils.JavaMailUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = { "/User/forgot" })
public class ForgotPasswordController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =req.getParameter("emailReset");
        String msg="";
        UserEntity user=null;
        if (email == null)
        {
            msg="Vui lòng nhập email";
        }
        else {
            user = userService.getUser(email);
            if (user == null ) {
                msg="Tài khoản không tồn tại";
            } else {
                Random random = new Random();
                Integer pass = random.nextInt(899999) + 100000;
                user.setPassword(pass.toString());
                userService.edit(user);
                String content = "Mật khẩu mới của bạn là: " + user.getPassword();
                try {
                    JavaMailUtil.sendMail(email, "Lấy lại mật khẩu", content);
                    msg = "Mật khẩu mới đã được gửi vào gmail của bạn.";
                } catch (Exception e) {
                    msg = "Thao tác thất bại, vui lòng thử lại.";
                    e.printStackTrace();
                }
            }
        }

        req.setAttribute("msg",msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/signin.jsp");
        dispatcher.forward(req, resp);
    }
}
