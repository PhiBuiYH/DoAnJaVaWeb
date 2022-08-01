package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.model.CustomerEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.CustomerService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartServiceImpl;
import com.webbanquanao.service.impl.CustomerServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;
import com.webbanquanao.utils.JavaMailUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns= {"/payment"})
public class PaymentController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("c_email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String note = req.getParameter("note");
        String optionPayment = req.getParameter("optionPayment");

        HttpSession httpSession = req.getSession();
        String u_email = (String) httpSession.getAttribute("email");
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");

        UserEntity userEntity = new UserEntity();
        userEntity = userService.getUser(u_email);
        int c_id = customerService.getCustomerId(userEntity.getId());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFullname(fullname);
        customerEntity.setEmail(email);
        customerEntity.setPhone(phone);
        customerEntity.setAddress(address);

        if(c_id!=0) {
            customerEntity.setId(c_id);
            customerService.edit(customerEntity);
        }
        else {
            customerService.insert(customerEntity);
            int new_c_id = customerService.getNewIDCustomer();
            customerEntity.setId(new_c_id);

            cartService.UpdateCustomer(cartEntity.getId(),new_c_id);
        }

        cartEntity.setCustomerEntity(customerEntity);
        httpSession.setAttribute("cartEntity",cartEntity);

        if(optionPayment.equals("online")){
            String chuoi="";
            chuoi+="upload=1";
            chuoi+="&&return=http://localhost:8080/Project_WebSite_Ban_Quan_Ao_war_exploded/cartSuccess";
            chuoi+="&&cmd=_cart";
            chuoi+="&&business=chuShop@gmail.com";

            int i=1;

            for(CartitemEntity cartitemEntity:cartEntity.getCartitemEntities()){
                chuoi+=removeAccent("&&item_name_"+i+"="+cartitemEntity.getSkuEntity().getProductEntity().getName());
                chuoi+="&&quantity_"+i+"="+cartitemEntity.getQuantity();
                chuoi+="&&amount_"+i+"="+(cartitemEntity.getSkuEntity().getProductEntity().getPrice()/24000);
                i++;
            }

            resp.sendRedirect("https://www.sandbox.paypal.com/cgi-bin/webscr?"+chuoi);
        }
        else
        {
//                          Nghĩa Bùi thêm gửi mail
            double totalPrice=0;
            StringBuilder content = new StringBuilder("<p>Xin chào "+ cartEntity.getUserEntity().getUserName()+"<p>");
            content.append("<p>Đơn hàng #"+cartEntity.getId()+" của bạn đã được giao thành công.</p>");
            content.append("<p>THÔNG TIN ĐƠN HÀNG - DÀNH CHO NGƯỜI MUA<p>");
            content.append("<table><tr><th>Tên Sản Phẩm       </th><th>Số lượng         </th><th>Đơn giá       </th></tr>");
            for(CartitemEntity item : cartEntity.getCartitemEntities()) {
                content.append("<tr><td>"+item.getSkuEntity().getProductEntity().getName()+"</td><td>    "+item.getQuantity()+"</td><td>   "+item.getSkuEntity().getProductEntity().getPrice()+" VNĐ</td></tr>");
                totalPrice += item.getQuantity()*item.getSkuEntity().getProductEntity().getPrice();
            }
            content.append("</table><br>");
            content.append("<p>Tổng Tiền : "+totalPrice+" VNĐ</p>");
            try {
                JavaMailUtil.sendMail(cartEntity.getCustomerEntity().getEmail(),"Đặt hàng thành công!",content.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/cartSuccess");
            dispatcher.forward(req, resp);
        }
    }

    private static final char[] SOURCE_CHARACTERS = {'À', 'Á', 'Â', 'Ã', 'È', 'É',
            'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
            'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
            'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
            'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
            'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
            'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
            'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
            'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
            'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
            'ữ', 'Ự', 'ự',};

    private static final char[] DESTINATION_CHARACTERS = {'A', 'A', 'A', 'A', 'E',
            'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
            'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
            'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
            'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u',};

    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    public static String removeAccent(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }
}

