package com.stc.petlove.service;

import com.stc.petlove.entities.Product;
import com.stc.petlove.payload.PageResponse;

import java.util.List;

public interface ProductService {
    PageResponse getAllProduct(int pageNo, int pageSize, String sortBy, String sortDir);
    Product getProductById(String id);
    Product saveProduct(Product product);
    Product updateProduct(String id,Product product);
    boolean deleteProduct(String id);
}
