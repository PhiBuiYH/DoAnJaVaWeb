package com.webbanquanao.controller.admin;

import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/sku/add"})
public class SkuAddController extends HttpServlet {
    SkuService skuService = new SkuServiceImpl();
    ProductService productService = new ProductServiceImpl();
    ColorService colorService = new ColorServiceImpl();
    SizeService sizeService = new SizeServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        String id = request.getParameter("id");
        ProductEntity product = productService.get(Integer.parseInt(id));
        request.setAttribute("id",id);
        request.setAttribute("product", product);
        List<ColorEntity> colors = colorService.getAll();
        request.setAttribute("colors", colors);
        List<SizeEntity> sizes = sizeService.getAll();
        request.setAttribute("sizes", sizes);

        int role = user.getPermission();
        String link = "/View/admin/add-sku.jsp";
        if(role == 1){
            link = "/View/admin/add-sku.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        SkuEntity skuEntity = new SkuEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        ServletContext context = request.getServletContext();
        final String dir = context.getRealPath("image");

        String id = "";

        try {

            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    skuEntity.setProductEntity(productService.get(Integer.parseInt(item.getString())));
                    id = item.getString();
                } else if (item.getFieldName().equals("color")) {
                    skuEntity.setColorEntity(colorService.get(Integer.parseInt(item.getString())));
                } else if (item.getFieldName().equals("size")) {
                    skuEntity.setSizeEntity(sizeService.get(Integer.parseInt(item.getString())));
                } else if (item.getFieldName().equals("quantity")) {
                    skuEntity.setQuantity(Integer.parseInt(item.getString()));
                }
            }

            skuService.insert(skuEntity);
            response.sendRedirect(request.getContextPath() + "/admin/sku/list?id=" + id);
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Two");
            response.sendRedirect(request.getContextPath() + "/admin/product/add?e=1");
        }

    }
}
