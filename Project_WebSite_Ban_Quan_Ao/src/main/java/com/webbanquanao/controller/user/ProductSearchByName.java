package com.webbanquanao.controller.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ColorService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.SizeService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ColorServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.SizeServiceImpl;

@WebServlet(urlPatterns="/product/SearchName")
public class ProductSearchByName extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();
    SizeService sizeService=new SizeServiceImpl();
    ColorService colorService=new ColorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryEntity> cateList = cateService.getAll();
        req.setAttribute("cateList",cateList);
        List<SizeEntity> sizeEntityList=sizeService.getAll();
        req.setAttribute("sizeList",sizeEntityList);

        List<ColorEntity> colorEntityList=colorService.getAll();
        req.setAttribute("colorList",colorEntityList);
        String name_search=req.getParameter("search_name");
        List<ProductEntity> productSeachByName =productService.searchByName(name_search);
        req.setAttribute("productList", productSeachByName);
        req.getRequestDispatcher("/View/User/ProductSearchByName.jsp").forward(req, resp);
    }
}
