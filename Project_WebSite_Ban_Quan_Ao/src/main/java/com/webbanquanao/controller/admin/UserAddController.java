package com.webbanquanao.controller.admin;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.UserService;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

import static org.hibernate.sql.InFragment.NULL;

@WebServlet(urlPatterns = { "/admin/user/add" })
public class UserAddController extends HttpServlet {
    UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();
        UserEntity user = userService.search(email);
        req.setAttribute("user",user.getUserName());
        String eString = req.getParameter("e");
        if (eString != null) {
            if (eString.equals("1")) {
                req.setAttribute("errMsg", "Username da ton tai!!!");
            }
        }
        int role = user.getPermission();
        String link = "/View/admin/add-user.jsp";
        if(role == 1){
            link = "/View/admin/add-user.jsp";
        }
        else{
            link = null;
        }
        req.getRequestDispatcher(link).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = new UserEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        /*File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(repository);*/

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        String url="";
        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("email"))
                {

                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("emailError", "Enter your email");
                        url = "0";
                    }
                    else
                    {
                        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
                        if(!pattern.matcher(item.getString()).matches())
                        {
                            req.getSession().setAttribute("emailError", "You must enter email in format x@x.x");
                            url = "0";
                        }
                        else if(userService.checkExistEmail(item.getString()))
                        {
                            req.getSession().setAttribute("emailError", "This email is already exist");
                            url = "0";
                        }
                        else {
                            req.getSession().setAttribute("emailError", null);
                        }

                    }
                    req.getSession().setAttribute("mail",item.getString());
                    user.setEmail(item.getString());
                } else if (item.getFieldName().equals("username"))
                {
                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("nameError", "Enter your your user name");
                        url = "0";
                    }
                    else {
                        req.getSession().setAttribute("nameError", null);
                    }
                    req.getSession().setAttribute("name",item.getString());
                    user.setUserName(item.getString());
                } else if (item.getFieldName().equals("password"))
                {
                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("passError", "Enter your your password");
                        url = "0";
                    }
                    else {
                        req.getSession().setAttribute("passError", null);
                    }

                    req.getSession().setAttribute("pass",item.getString());
                    user.setPassword(item.getString());
                }else if (item.getFieldName().equals("address")) {

                    req.getSession().setAttribute("address",item.getString());
                    user.setAddress(item.getString());
                }
                else if (item.getFieldName().equals("phone"))
                {

                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("phoneError", "Enter your phone");
                        url = "0";
                    }
                    else
                    {
                        Pattern pattern = Pattern.compile("[0-9]{3}[0-9]{3}[0-9]{4}");
                        if(!pattern.matcher(item.getString()).matches())
                        {
                            req.getSession().setAttribute("phoneError", "You must enter phone in format xxx-xxx-xxxx");
                            url = "0";
                        }
                        else {
                            req.getSession().setAttribute("phoneError", null);
                        }

                    }
                    req.getSession().setAttribute("phone",item.getString());
                    user.setPhone(item.getString());
                }
                else if (item.getFieldName().equals("permission")) {
                    req.getSession().setAttribute("permission",Integer.parseInt(item.getString()));
                    user.setPermission(Integer.parseInt(item.getString()));;
                } else if (item.getFieldName().equals("avatar")) {
                    if (item.getSize() > 0) {
                        String originalFileName = item.getName();
                        Path path = Paths.get(originalFileName);
                        final String storepath = servletContext.getRealPath("image");
                        System.out.println("File1: " + storepath +File.separator + path.getFileName());
                        File file = new File(storepath + File.separator + path.getFileName());
                        if (!file.exists() && !file.isDirectory()) {
                            item.write(file);
                        }
                        System.out.println("File1:Thanh Cong ");
                        req.getSession().setAttribute("avatar",originalFileName);
                        user.setAvatar(originalFileName);
                    }
                    else
                    {
                        user.setAvatar(null);
                    }
                }
            }

            if(url!="0") {
                userService.insert(user);
                resp.sendRedirect(req.getContextPath() + "/admin/user/list");
            }
            else
            {
                resp.sendRedirect(req.getContextPath() + "/admin/user/add");
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/admin/user/add?e=1");
        }

    }
}
