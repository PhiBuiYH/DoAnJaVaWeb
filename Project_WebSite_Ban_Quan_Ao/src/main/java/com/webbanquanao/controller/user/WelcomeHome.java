package com.webbanquanao.controller.user;


import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/Home")
public class WelcomeHome extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Reset value
        HttpSession sessProperty = request.getSession();
        sessProperty.setAttribute("brand_id",0);
        sessProperty.setAttribute("cate_id",0);
        sessProperty.setAttribute("color_id",0);
        sessProperty.setAttribute("size_id",0);
        sessProperty.setAttribute("startPrice",0);
        sessProperty.setAttribute("endPrice",10000000);
        sessProperty.setAttribute("page",1);


        List<ProductEntity> productList = productService.getAll();
        List<CategoryEntity> cateList = cateService.getAll();
        request.setAttribute("cateList",cateList);
        List<ProductEntity> newList = new ArrayList<>();
        try {
            String cate=request.getParameter("cateid");
            if(cate!=null)
                productList = productService.searchByName(cate);
        }
        catch (Exception e)
        {}
        for (int i = 0; i <productList.size() ; i++)
        {
            if(i<=8)
                newList.add(productList.get(i));
        }
        int role = 0;
        try {
            HttpSession session = request.getSession();
            String email = session.getAttribute("email").toString();
            UserEntity user = userService.search(email);
            request.setAttribute("user",user.getUserName());
            role = user.getPermission();
            request.setAttribute("email", email);
        }
        catch (Exception e) {
        }

        request.setAttribute("productList",newList);
        request.setAttribute("allproduct",productService.getAll());
        String link = "";
        if(role == 0){
            link = "/View/User/index.jsp";
        }
        else{
            link = "/View/admin/index.jsp";
        }
        request.getRequestDispatcher(link).forward(request, response);
    }

}


