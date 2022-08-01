package com.webbanquanao.controller.user;

import clojure.lang.Obj;
import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.BrandService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.BrandServiceImpl;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns="/product/searchByProperties")
public class ProductSearchByProperties extends HttpServlet {
    ProductService productService  = new ProductServiceImpl();
    BrandService brandService = new BrandServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();
    SizeService sizeService=new SizeServiceImpl();
    ColorService colorService=new ColorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<SizeEntity> sizeEntityList=sizeService.getAll();
        req.setAttribute("sizeList",sizeEntityList);

        List<ColorEntity> colorEntityList=colorService.getAll();
        req.setAttribute("colorList",colorEntityList);
        HttpSession sessProperty = req.getSession();
        String brandid=req.getParameter("brandid");
        String cateid= req.getParameter("cateid") ;
        String colorid = req.getParameter("colorid");
        String sizeid =req.getParameter("sizeid");
        String pageCurrent = req.getParameter("page");
        String startPrice = req.getParameter("startPrice");
        String endPrice = req.getParameter("endPrice");
        if (brandid !=null) {
            sessProperty.setAttribute("brand_id",Integer.parseInt(brandid));
            sessProperty.setAttribute("cate_id",null);
            sessProperty.setAttribute("color_id",0);
            sessProperty.setAttribute("size_id",0);
            sessProperty.setAttribute("startPrice",0);
            sessProperty.setAttribute("endPrice",10000000);
            sessProperty.setAttribute("page",1);
        }

        List<CategoryEntity> cateList = cateService.getAll();
        req.setAttribute("cateList",cateList);
        if (cateid !=null) {
            sessProperty.setAttribute("cate_id",Integer.parseInt(cateid));
            sessProperty.setAttribute("brand_id",0);
            sessProperty.setAttribute("color_id",0);
            sessProperty.setAttribute("size_id",0);
            sessProperty.setAttribute("startPrice",0);
            sessProperty.setAttribute("endPrice",10000000);
            sessProperty.setAttribute("page",1);
        } else {
            if (sessProperty.getAttribute("cate_id")==null){

                sessProperty.setAttribute("cate_id",0);
                sessProperty.setAttribute("color_id",0);
                sessProperty.setAttribute("size_id",0);
                sessProperty.setAttribute("page",1);
                sessProperty.setAttribute("startPrice",0);
                sessProperty.setAttribute("endPrice",10000000);

            }


            if (colorid !=null){
                sessProperty.setAttribute("color_id",Integer.parseInt(colorid) );
            }
            if (sizeid !=null) {
                sessProperty.setAttribute("size_id",Integer.parseInt(sizeid) );
            }
            if (pageCurrent!=null){
                sessProperty.setAttribute("page",Integer.parseInt(pageCurrent));
            }
            if (startPrice!=null && endPrice != null) {
                sessProperty.setAttribute("startPrice",Integer.parseInt(startPrice));
                sessProperty.setAttribute("endPrice",Integer.parseInt(endPrice));
            }
        }
        int brand_id=0;
        if (sessProperty.getAttribute("brand_id") !=null) {
            brand_id = (int) sessProperty.getAttribute("brand_id");
        }
        else brand_id=0;
        int cate_id= (int) sessProperty.getAttribute("cate_id");
        int color_id= (int)sessProperty.getAttribute("color_id");
        int size_id= (int)sessProperty.getAttribute("size_id");
        int page =(int) sessProperty.getAttribute("page");
        int start_price = (int) sessProperty.getAttribute("startPrice");
        int end_price = (int) sessProperty.getAttribute("endPrice");

        List<Object> values = new ArrayList<>();
        values.add(0,(cate_id==0)?null:cate_id);
        values.add(1,(color_id==0)?null:color_id);
        values.add(2,(size_id==0)?null:size_id);
        values.add(3,start_price);
        values.add(4,end_price);
        values.add(5,(brand_id==0)?null:brand_id);
//        map.put("cateId",null);
//        map.put("colorId",1);
//        map.put("sizeId",null);


        int litmit=9;
        int offset = (page-1) * litmit;

        Object[] obj = productService.searchByProperties(values,offset,litmit);

        int numOfProducts=(int)obj[1];

        int numOfPages = 0;
        if (numOfProducts/litmit==(float)numOfProducts/litmit){
            numOfPages = numOfProducts/litmit;
        }
        else{
            numOfPages = numOfProducts/litmit+1;
        }

        List<BrandEntity> listBrand = brandService.getAll();
        req.setAttribute("listBrand", listBrand);

        List<ProductEntity> products = (List<ProductEntity>) obj[0];
        req.setAttribute("numOfPages",numOfPages);
        req.setAttribute("productList",products);

        req.getRequestDispatcher("/View/User/product.jsp").forward(req, resp);
    }
}
