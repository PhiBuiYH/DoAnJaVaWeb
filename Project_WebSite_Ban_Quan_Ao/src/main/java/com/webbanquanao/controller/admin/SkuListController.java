package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.SkuService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.SkuServiceImpl;
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

@WebServlet(urlPatterns= {"/admin/sku/list"})
public class SkuListController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    SkuService skuService = new SkuServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        String id = request.getParameter("id");
        List<SkuEntity> listSku = skuService.searchByProduct(Integer.parseInt(id));
        request.setAttribute("id",id);
        //ProductEntity product = productService.get();
        //List<SkuEntity> listSku = skuService.getAll();
        request.setAttribute("listSku", listSku);
        int role = user.getPermission();
        String link = "/View/admin/list-sku.jsp";
        if(role == 1){
            link = "/View/admin/list-sku.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }
}
