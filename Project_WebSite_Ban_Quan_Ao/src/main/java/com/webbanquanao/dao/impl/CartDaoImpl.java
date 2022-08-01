package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CartDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.model.ProductEntity;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public void insert(CartEntity cart) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("Insert into cart(u_id,buyDate,action,status) values(:u_id,:buyDate,:action,:status)");
        query.setParameter("u_id",cart.getUserEntity().getId());
        query.setParameter("buyDate",cart.getBuyDate());
        query.setParameter("action",cart.getAction());
        query.setParameter("status",0);
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(CartEntity cart) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("UPDATE cart SET action = :action WHERE id = :id");
        query.setParameter("id", cart.getId());
        query.setParameter("action", cart.getAction());
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            CartEntity cart = em.find(CartEntity.class, id);
            trans.begin();
//            CartitemEntity cartitemEntity = em.find(CartitemEntity.class,id);
            String qString = "delete FROM CartitemEntity C WHERE C.cartEntity.id =:id";
            Query q = em.createQuery(qString);
            q.setParameter("id",id);
            int result= q.executeUpdate();
            em.remove(em.merge(cart));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public CartEntity get(int id) {
 /*       String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id WHERE cart.id=?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                return cart;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();

        try{
            CartEntity cart = em.find(CartEntity.class, id);
            return cart;
        }
        finally {
            em.close();
        }

    }

    @Override
    public List<CartEntity> getAll() {
        /*List<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;*/

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM CartEntity ";
        TypedQuery<CartEntity> q = em.createQuery(qString,CartEntity.class);

        List<CartEntity> cartList = new ArrayList<CartEntity>();
        try{
            cartList = q.getResultList();
            if(cartList == null || cartList.isEmpty())
                cartList= null;
        }finally {
            em.close();
        }
        return cartList;
    }

    @Override
    public List<CartEntity> getByUserId(int id) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM CartEntity C where C.userEntity.id =:id";
        TypedQuery<CartEntity> q = em.createQuery(qString,CartEntity.class);
        q.setParameter("id",id);
        List<CartEntity> cartList = new ArrayList<CartEntity>();
        try{
            cartList = q.getResultList();
            if(cartList == null || cartList.isEmpty())
                cartList= null;
        }finally {
            em.close();
        }
        return cartList;
    }

    public List<CartEntity> search(String name) {
  /*      List<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;*/
        return null;
    }

    @Override
    public CartEntity get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeProduct(CartEntity cart, int pId){
        List <CartitemEntity> cartItems = cart.getCartitemEntities();
        cartItems.remove(pId);
        cart.setCartitemEntities(cartItems);
    }

    @Override
    public double totalBill(CartEntity cart) {
        double total = 0;
        try {
            total = cart.getCartitemEntities().stream().mapToDouble(cartItem -> cartItem.getSkuEntity().getProductEntity().getPrice() * cartItem.getQuantity()).sum();
        }
        catch(Exception e)
        {}
        return total;
    }

    @Override
    public int getIDCart(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id = (int) getSession.createSQLQuery("SELECT id FROM cart ORDER BY id DESC LIMIT 1").addScalar("id",new IntegerType()).uniqueResult();
        try{

            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }

    @Override
    public List<CartitemEntity> getCart(int u_id){
        List<CartitemEntity> resultList;
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("Select cartitem.id,cartitem.pro_id,cartitem.cart_id,cartitem.quantity From cartitem,(" +
                                                   "Select id From cart where u_id = :u_id and action=0) as cartWithId " +
                                                   "Where cartitem.cart_id = cartWithId.id;");
        query.setParameter("u_id",u_id);
        try{
            resultList = query.getResultList();
 /*           for(CartitemEntity cartItem:resultList){
                System.out.println(cartItem.getId());
                System.out.println(cartItem.getQuantity());
                System.out.println(cartItem.getCartEntity().getId());
                System.out.println(cartItem.getProductEntity().getId());
            }*/
    //        getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
        return resultList;
    }

    @Override
    public void UpdateCustomer(int id, int c_id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("UPDATE cart SET c_id = :c_id WHERE id = :id");
        query.setParameter("id", id);
        query.setParameter("c_id", c_id);;
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void updateStatus(CartEntity cart) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(cart);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
}
