package com.stc.petlove.service;

import com.stc.petlove.entities.Cart;
import com.stc.petlove.payload.PageResponse;

public interface CartService {
    PageResponse getAllCart(int pageNo, int pageSize, String sortBy, String sortDir);
    Cart getCartById(String id);
    Cart saveCart(Cart cart);
    Cart updateCart(String id, Cart cart);
    boolean deleteCart(String id);
}
