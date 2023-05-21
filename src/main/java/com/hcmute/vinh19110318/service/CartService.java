package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.Cart;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface CartService {
    PageResponse getAllCart(int pageNo, int pageSize, String sortBy, String sortDir);
    Cart getCartById(String id);
    Cart saveCart(Cart cart);
    Cart updateCart(String id, Cart cart);
    boolean deleteCart(String id);
}
