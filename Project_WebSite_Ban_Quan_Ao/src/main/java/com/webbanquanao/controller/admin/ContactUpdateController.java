package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.ContactService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.ContactServiceImpl;
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

@WebServlet(urlPatterns = { "/admin/contact/update" })
public class ContactUpdateController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        req.setAttribute("user",user.getUserName());
        int id= Integer.parseInt((String)req.getParameter("id"));
        int value = Integer.parseInt((String)req.getParameter("value"));
        contactService.updateAction(id,value);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/contact/list");
        dispatcher.forward(req, resp);
    }
}
