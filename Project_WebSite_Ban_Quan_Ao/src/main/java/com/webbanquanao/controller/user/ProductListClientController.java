package com.webbanquanao.controller.user;


import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = { "/user/product/list" })
public class ProductListClientController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	BrandService brandService = new BrandServiceImpl();
	SizeService sizeService=new SizeServiceImpl();
	ColorService colorService=new ColorServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		List<ProductEntity> products = productService.getAll();
		int numOfProducts = products.size();int litmit=9;int numOfPages = 0;
		if (numOfProducts/litmit==(float)numOfProducts/litmit){
			numOfPages = numOfProducts/litmit;
		}
		else
			{
			numOfPages = numOfProducts/litmit+1;
		}
		int page = Integer.parseInt(req.getParameter("page"));
		int offset = (page-1) * litmit;
		List<ProductEntity> productList=productService.getByPage(offset,litmit);
		req.setAttribute("productList", productList);
		List<CategoryEntity> cateList = cateService.getAll();
		req.setAttribute("cateList",cateList);

		List<SizeEntity> sizeEntityList=sizeService.getAll();
		req.setAttribute("sizeList",sizeEntityList);

		List<ColorEntity> colorEntityList=colorService.getAll();
		req.setAttribute("colorList",colorEntityList);



		req.setAttribute("numOfPages",numOfPages);

		List<BrandEntity> listBrand = brandService.getAll();
		req.setAttribute("listBrand", listBrand);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/product.jsp");
		dispatcher.forward(req, resp);
	}

}
