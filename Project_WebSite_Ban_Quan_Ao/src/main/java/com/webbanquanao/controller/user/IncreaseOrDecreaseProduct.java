package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/member/cart/increaseOrDecrease" }) // ?pId=123
public class IncreaseOrDecreaseProduct extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        int quantity = 1;
        int check;
        if(req.getParameter("pId")!=null) {
            id = Integer.parseInt(req.getParameter("pId"));
            check = Integer.parseInt(req.getParameter("check"));
            ProductEntity productEntity = productService.get(id);
            HttpSession session = req.getSession();
            CartEntity cartEntity = (CartEntity) session.getAttribute("cartEntity");
            List<CartitemEntity> listCartItem = cartEntity.getCartitemEntities();
            if(check ==0) {
                for (CartitemEntity cartitemEntity : listCartItem) {
                    if (cartitemEntity.getSkuEntity().getProductEntity().getId() == productEntity.getId() && cartitemEntity.getQuantity() > 1) {
                        cartitemEntity.setQuantity(cartitemEntity.getQuantity() - quantity);
                        cartItemService.edit(cartitemEntity);
                        break;
                    }
                }
            }
            else {
                for (CartitemEntity cartitemEntity : listCartItem) {
                    if (cartitemEntity.getSkuEntity().getProductEntity().getId() == productEntity.getId() &&
                            cartitemEntity.getQuantity()<cartitemEntity.getSkuEntity().getQuantity()) {
                        cartitemEntity.setQuantity(cartitemEntity.getQuantity() + quantity);
                        cartItemService.edit(cartitemEntity);
                        break;
                    }
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/member/cart");
    }
}