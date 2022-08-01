package com.webbanquanao.controller.user;

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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns="/product/searchByPrice")
public class ProductSearchByPrice extends HttpServlet{
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
        double startPrice=Double.parseDouble(req.getParameter("startPrice"));
        double endPrice=Double.parseDouble(req.getParameter("endPrice"));
        int numOfProducts=0;
        List<ProductEntity> products =productService.searchByPrice(startPrice,endPrice);
        if (products != null){
            numOfProducts =products.size();
        }
        int litmit=9;
        int numOfPages = 0;
        if (numOfProducts/litmit==(float)numOfProducts/litmit){
            numOfPages = numOfProducts/litmit;
        }
        else{
            numOfPages = numOfProducts/litmit+1;
        }
        int page = Integer.parseInt(req.getParameter("page"));
        int offset = (page-1) * litmit;
        List<ProductEntity> productList=productService.getByPageAndPrice(startPrice,endPrice, offset,litmit);

        req.setAttribute("numOfPages",numOfPages);
        req.setAttribute("productList", productList);
        req.setAttribute("startPrice",startPrice);
        req.setAttribute("endPrice",endPrice);
        req.getRequestDispatcher("/View/User/ProductSearchByPrice.jsp").forward(req, resp);
    }
}

