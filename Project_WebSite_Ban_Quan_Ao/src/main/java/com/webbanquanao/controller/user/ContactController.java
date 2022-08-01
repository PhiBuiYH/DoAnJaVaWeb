package com.webbanquanao.controller.user;

import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.service.ContactService;
import com.webbanquanao.service.impl.ContactServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/contactController")
public class ContactController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactEntity contact = new ContactEntity();
        String infoMsg="";
        contact.setName((String) req.getParameter("userName"));
        contact.setEmail((String) req.getParameter("userEmail"));
        contact.setMobile((String) req.getParameter("userPhone"));
        contact.setSubject((String) req.getParameter("userMsg"));
        if (contact.getName().equals("")) {
            infoMsg = "Tên không được để trống";
        } else if (contact.getSubject().equals("")) {
            infoMsg ="Nội dung không được để trống";
        } else {
            contactService.insert(contact);
            infoMsg="Đã gửi ý kiến phản hồi thành công";
        }
        req.setAttribute("infoMsg",infoMsg);
        resp.sendRedirect(req.getContextPath() + "/View/User/contact.jsp");

/*
        RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() +"/View/User/contact.jsp");
        dispatcher.forward(req, resp);
*/
    }
}
