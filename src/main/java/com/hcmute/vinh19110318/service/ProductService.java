package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.Product;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface ProductService {
    PageResponse getAllProduct(int pageNo, int pageSize, String sortBy, String sortDir);
    Product getProductById(String id);
    Product saveProduct(Product product);
    Product updateProduct(String id,Product product);
    boolean deleteProduct(String id);
}
