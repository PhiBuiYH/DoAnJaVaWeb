package com.webbanquanao.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;

@WebServlet(urlPatterns="/product/detail")
public class ProductDetailController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    SizeService sizeService=new SizeServiceImpl();
    ColorService colorService=new ColorServiceImpl();
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ProductEntity> productList = productService.getAll();
        List<CategoryEntity> cateList = categoryService.getAll();
        req.setAttribute("cateList",cateList);
        SkuService skuService = new SkuServiceImpl();
        Random rand = new Random();
        List<ProductEntity> newList = new ArrayList<>();
        List<String> listcolor=new ArrayList<String>();
        List<String> listsize=new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(productList.size());
            newList.add(productList.get(randomIndex));
        }

        req.setAttribute("RelateProductList", newList);
        String id = req.getParameter("id");
        ProductEntity product = productService.get(Integer.parseInt(id));
        List<CategoryEntity> categories = categoryService.getAll();
        List<SkuEntity> listSku = skuService.searchByProduct(Integer.parseInt(id));
        Integer[] maxquantity={0};

        listSku.forEach((element)->
        {
            if(maxquantity[0]<element.getQuantity())
            maxquantity[0]=element.getQuantity();
            if(!listcolor.contains(element.getColorEntity().getColorName()))
            {
                listcolor.add(element.getColorEntity().getColorName());
            }
            if(!listsize.contains(element.getSizeEntity().getSizeName()))
            {
                listsize.add(element.getSizeEntity().getSizeName());
            }
        });
        List<SizeEntity> sizeEntityList=sizeService.getAll();
        req.setAttribute("sizeList",sizeEntityList);

        List<ColorEntity> colorEntityList=colorService.getAll();
        req.setAttribute("colorList",colorEntityList);

        List<BrandEntity> listBrand = brandService.getAll();
        req.setAttribute("listBrand", listBrand);

        req.setAttribute("listSku", listSku);
        req.setAttribute("listColor", listcolor);
        req.setAttribute("listSize", listsize);
        req.setAttribute("categories", categories);
        req.setAttribute("product", product);
        req.setAttribute("maxquantity",maxquantity[0]);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/product-detail.jsp");
        dispatcher.forward(req, resp);
    }
}
