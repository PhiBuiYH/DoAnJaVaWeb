package com.webbanquanao.controller.admin;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.BrandService;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.BrandServiceImpl;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;
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
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    BrandService brandService = new BrandServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());
        String id = request.getParameter("id");
        ProductEntity product = productService.get(Integer.parseInt(id));
        List<CategoryEntity> categories = categoryService.getAll();
        List<BrandEntity> listBrand = brandService.getAll();
        request.setAttribute("listBrand", listBrand);
        request.setAttribute("categories", categories);
        request.setAttribute("product", product);

        int role = user.getPermission();
        String link = "/View/admin/edit-product.jsp";
        if(role == 1){
            request.getRequestDispatcher(link).forward(request, response);
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductEntity product = new ProductEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);


        ServletContext context = request.getServletContext();
        final String dir = context.getRealPath("image");

        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);

            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    product.setId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("name")) {
                    product.setName(item.getString());
                } else if (item.getFieldName().equals("cate")) {
                    product.setCategoryEntity(categoryService.get(Integer.parseInt(item.getString())));
                } else if (item.getFieldName().equals("brand")) {
                    product.setBrandEntity(brandService.get(Integer.parseInt(item.getString())));
                } else if (item.getFieldName().equals("des")) {
                    product.setDes(item.getString());
                } else if (item.getFieldName().equals("price")) {
                    product.setPrice(Double.parseDouble(item.getString()));
                } else if (item.getFieldName().equals("image")) {
                    if (item.getSize() > 0) {// neu co file d
                        String originalFileName = item.getName();
                        File file = new File(dir + File.separator + originalFileName);
                        if (!file.exists() && !file.isDirectory()) {
                            item.write(file);
                        }

                        product.setImage(originalFileName);

                    } else {

                        product.setImage(null);
                    }
                }
            }
            productService.edit(product);

            response.sendRedirect(request.getContextPath() + "/admin/product/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

