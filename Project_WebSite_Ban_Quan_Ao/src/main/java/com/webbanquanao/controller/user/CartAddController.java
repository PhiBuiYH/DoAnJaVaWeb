package com.webbanquanao.controller.user;

import com.webbanquanao.model.*;
import com.webbanquanao.service.*;
import com.webbanquanao.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;


@WebServlet(urlPatterns = { "/member/cart/add" }) // ?pId=123
public class CartAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();
    ColorService colorService = new ColorServiceImpl();
    SizeService sizeService = new SizeServiceImpl();
    SkuService skuService = new SkuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String email = (String) httpSession.getAttribute("email");

        String color = (String) req.getParameter("color");
        String size = (String) req.getParameter("size");

        UserService userService = new UserServiceImpl();
        int quantity = 1;
        int p_id;
        if(req.getParameter("pId")!=null){
            p_id = Integer.parseInt(req.getParameter("pId"));
            ProductEntity productEntity = productService.get(p_id);
            if(productEntity!=null){
                if(req.getParameter("quantity")!=null){
                    quantity = Integer.parseInt(req.getParameter("quantity"));
                }
                if(httpSession.getAttribute("cartEntity") == null){

                    int color_id = colorService.getColorId(color);
                    int size_id = sizeService.getSizeId(size);
                    int maxquantity = 0;

                    maxquantity = skuService.getMaxQuantity(p_id, color_id, size_id);


                    int sku_id = skuService.getSkuId(p_id,color_id,size_id);

                    ColorEntity colorEntity = new ColorEntity();
                    colorEntity.setColorId(color_id);
                    colorEntity.setColorName(color);

                    SizeEntity sizeEntity = new SizeEntity();
                    sizeEntity.setSizeId(size_id);
                    sizeEntity.setSizeName(size);

                    SkuEntity skuEntity = new SkuEntity();
                    skuEntity.setSkuId(sku_id);
                    skuEntity.setProductEntity(productEntity);
                    skuEntity.setColorEntity(colorEntity);
                    skuEntity.setSizeEntity(sizeEntity);
                    skuEntity.setQuantity(maxquantity);

                    CartEntity cartEntity = new CartEntity();
                    List<CartitemEntity> listCartItem =new ArrayList<CartitemEntity>();

                    CartitemEntity cartitemEntity = new CartitemEntity();
                    cartitemEntity.setQuantity(quantity);
                    cartitemEntity.setSkuEntity(skuEntity);
                    listCartItem.add(cartitemEntity);

                    cartEntity.setCartitemEntities(listCartItem);
                    long millis=System.currentTimeMillis();
                    java.sql.Date date=new java.sql.Date(millis);
                    cartEntity.setBuyDate(date);
                    cartEntity.setAction(false);
                    if(email!=null) {
                        UserEntity userEntity = userService.getUser(email);
                        cartEntity.setUserEntity(userEntity);
                        cartService.insert(cartEntity);
                        int idCart = cartService.getIDCart();
                        cartEntity.setId(idCart);

                        cartitemEntity.setCartEntity(cartEntity);
                        cartItemService.insert(cartitemEntity);
                        int idCartItem = cartItemService.getIDCartItem();
                        cartitemEntity.setId(idCartItem);
                    }

                    httpSession.setAttribute("cartEntity",cartEntity);
                }
                else{
                    CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");
                    List<CartitemEntity> listCartItem = cartEntity.getCartitemEntities();
                    boolean check = false;
                    for(CartitemEntity cartitemEntity : listCartItem){
                        if(cartitemEntity.getSkuEntity().getProductEntity().getId() == productEntity.getId()){
                            if(cartitemEntity.getQuantity()<cartitemEntity.getSkuEntity().getQuantity()) {
                                cartitemEntity.setQuantity(cartitemEntity.getQuantity() + quantity);
                                if (email != null)
                                    cartItemService.edit(cartitemEntity);
                            }
                            check = true;
                        }
                    }
                    if(check == false){

                        int color_id = colorService.getColorId(color);
                        int size_id = sizeService.getSizeId(size);

                        int maxquantity = skuService.getMaxQuantity(p_id, color_id, size_id);
                        int sku_id = skuService.getSkuId(p_id,color_id,size_id);

                        ColorEntity colorEntity = new ColorEntity();
                        colorEntity.setColorId(color_id);
                        colorEntity.setColorName(color);

                        SizeEntity sizeEntity = new SizeEntity();
                        sizeEntity.setSizeId(size_id);
                        sizeEntity.setSizeName(size);

                        SkuEntity skuEntity = new SkuEntity();
                        skuEntity.setSkuId(sku_id);
                        skuEntity.setProductEntity(productEntity);
                        skuEntity.setColorEntity(colorEntity);
                        skuEntity.setSizeEntity(sizeEntity);
                        skuEntity.setQuantity(maxquantity);

                        CartitemEntity cartitemEntity = new CartitemEntity();
                        cartitemEntity.setQuantity(quantity);

                        cartitemEntity.setSkuEntity(skuEntity);
                        cartitemEntity.setCartEntity(cartEntity);
                        cartEntity.setCartitemEntities(listCartItem);
                        if(email!=null) {
                            if(cartEntity.getId()==0)
                            {
                                UserEntity userEntity = userService.getUser(email);
                                cartEntity.setUserEntity(userEntity);
                                cartService.insert(cartEntity);
                                int idCart = cartService.getIDCart();
                                cartEntity.setId(idCart);

                                for(CartitemEntity cartItem : listCartItem){
                                    cartItem.setCartEntity(cartEntity);
                                    cartItemService.insert(cartItem);
                                    int IdCartItem = cartItemService.getIDCartItem();
                                    cartItem.setId(IdCartItem);
                                }
                            }
                            cartitemEntity.setCartEntity(cartEntity);
                            cartItemService.insert(cartitemEntity);
                            int idCartItem = cartItemService.getIDCartItem();
                            cartitemEntity.setId(idCartItem);
                        }
                        listCartItem.add(cartitemEntity);
                    }
                    httpSession.setAttribute("cartEntity",cartEntity);
                }
            }
            resp.sendRedirect(req.getContextPath()+"/member/cart");
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/member/cart");
        }
    }
}
