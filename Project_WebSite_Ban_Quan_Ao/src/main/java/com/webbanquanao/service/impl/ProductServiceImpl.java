package com.webbanquanao.service.impl;

import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.dao.impl.ProductDaoImpl;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void insert(ProductEntity product){
        productDao.insert(product);
    }

    @Override
    public void edit(ProductEntity newProduct) {
        ProductEntity oldProduct = productDao.get(newProduct.getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategoryEntity(newProduct.getCategoryEntity());
        oldProduct.setBrandEntity(newProduct.getBrandEntity());
        oldProduct.setDes(newProduct.getDes());
        if (newProduct.getImage() != null) {
            // XOA ANH CU DI
//            String fileName = oldProduct.getImage();
//            final String dir = "F:\\upload";
//            final String dir = context.getRealPath("image");
//            File file = new File(dir + "/" + fileName);
//            if (file.exists()) {
//                file.delete();
//            }

            oldProduct.setImage(newProduct.getImage());
        }

        productDao.edit(oldProduct);

    }

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }

    @Override
    public ProductEntity get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<ProductEntity> search(String product) {
        return productDao.search(product);
    }

    @Override
    public List<ProductEntity> searchByCategory(String cate_name) {
        return productDao.searchByCategory(cate_name);
    }

    @Override
    public List<ProductEntity> searchByName(String productName) {
        return productDao.searchByName(productName);
    }

    public List<ProductEntity> searchByPrice(double priceStart,double priceEnd) {
        return productDao.searchByPrice(priceStart,priceEnd);
    }

    @Override
    public List<ProductEntity> getByPage(int offset, int limit) {
        return productDao.getByPage(offset,limit);
    }

    public List<ProductEntity> getByPageAndPrice(double priceStart,double priceEnd,int offset, int limit){
        return productDao.getByPageAndPrice(priceStart,priceEnd,offset, limit);
    }

    public List<ProductEntity> searchByPageAndCategory(String cate_name,int offset, int limit){
        return productDao.searchByPageAndCategory(cate_name,offset,limit);
    }

    public Object[] searchByProperties(List<Object> map, int offset, int limit){
        return productDao.searchByProperties(map,offset,limit);
    }
}
