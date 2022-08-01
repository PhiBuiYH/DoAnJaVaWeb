package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CustomerEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.CustomerService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartServiceImpl;
import com.webbanquanao.service.impl.CustomerServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns= {"/User/checkout"})
public class CheckOutController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String email = (String) httpSession.getAttribute("email");
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");

        if(email == null){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/signin.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            UserEntity userEntity = new UserEntity();
            userEntity = userService.getUser(email);
            int c_id = customerService.getCustomerId(userEntity.getId());
            if(c_id != 0){
                cartService.UpdateCustomer(cartEntity.getId(),c_id);
                CustomerEntity customerEntity = new CustomerEntity();
                customerEntity = customerService.getCustomer(c_id);
                cartEntity.setCustomerEntity(customerEntity);
                httpSession.setAttribute("cartEntity",cartEntity);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/payment.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
