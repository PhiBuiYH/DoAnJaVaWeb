package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartServiceImpl;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = { "/User/signin" })
public class SignInController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartEntity cartEntity = new CartEntity();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/signin.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserEntity user = new UserEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        /*File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(repository);*/

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        String url="";
        String email = "";
        String pass = "";
        String passError = null;
        AtomicReference<Boolean> admin = new AtomicReference<>(false);
        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("email"))
                {
                    user.setEmail(item.getString());
                    email = item.getString();


                } else if (item.getFieldName().equals("password"))
                {
                    user.setPassword(item.getString());
                    pass = item.getString();
                }


            }

            if(email.equals("")){
                session.setAttribute("SignInErr","Enter your Email.");

                resp.sendRedirect(req.getContextPath() + "/User/signin");
            }
//            else if(!userService.checkExistEmail(email)){
//                session.setAttribute("SignInErr","This Email was used.");
//                resp.sendRedirect(req.getContextPath() + "/User/signup");
//            }
            else if(pass.equals("")){
                session.setAttribute("SignInErr","Enter password");
                resp.sendRedirect(req.getContextPath() + "/User/signin");
            }
            else if(userService.checkExistAccount(email,pass)){
                session.setAttribute("email",email);
                String home = "/Home";
                UserEntity users = userService.search(email);
                if(users.getPermission().equals(1)){
                    home = "/admin";
                }

              /*  if(home == "/Home")
                    for(UserEntity u: users){
                        System.out.println("Hello World!!!");
                        cartEntity.setCartitemEntities(cartService.getCart(u.getId()));
                        session.setAttribute("cartEntity", cartEntity);
                    }*/
                resp.sendRedirect(req.getContextPath() + home);

            }
            else{
                session.setAttribute("SignInErr","Email or Password is not correct!");
                resp.sendRedirect(req.getContextPath() + "/User/signin");
            }
            //req.setAttribute("passError","Those passwords didn't match. Try again.");


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            /*resp.sendRedirect(req.getContextPath() + "/admin/user/add?e=1");*/
            resp.sendRedirect(req.getContextPath() + "/admin/user/list");
        }

    }
}
