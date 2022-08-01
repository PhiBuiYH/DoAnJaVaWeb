package com.webbanquanao.controller.admin;

import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ColorService;
import com.webbanquanao.service.SizeService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ColorServiceImpl;
import com.webbanquanao.service.impl.SizeServiceImpl;
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

@WebServlet(urlPatterns = { "/admin/size/edit" })
public class SizeEditController extends HttpServlet {
    SizeService sizeService = new SizeServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        request.setAttribute("user",user.getUserName());

        String id = request.getParameter("id");
        SizeEntity size = sizeService.get(Integer.parseInt(id));
        request.setAttribute("size", size);
        int role = user.getPermission();
        String link = "/View/admin/edit-size.jsp";
        if(role == 1){
            link = "/View/admin/edit-size.jsp";
        }
        else{
            link = null;
        }
        request.getRequestDispatcher(link).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SizeEntity size = new SizeEntity();

        //     response.sendRedirect(request.getContextPath()+"/admin/category/list");

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("sizeid")) {
                    size.setSizeId(Integer.parseInt(item.getString()));
                }
                else if(item.getFieldName().equals("sizename")){
                    size.setSizeName(item.getString());
                }
            }

            sizeService.edit(size);

            response.sendRedirect(request.getContextPath() + "/admin/size/list");

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}