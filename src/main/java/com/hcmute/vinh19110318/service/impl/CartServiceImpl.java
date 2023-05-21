package com.hcmute.vinh19110318.service.impl;

import com.hcmute.vinh19110318.entities.Cart;
import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.repository.CartRepository;
import com.hcmute.vinh19110318.exception.NotFoundException;
import com.hcmute.vinh19110318.service.CartService;
import com.hcmute.vinh19110318.service.SetPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final SetPageResponse<Cart> setPageResponse;
    @Override
    public PageResponse getAllCart(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<Cart> carts  = cartRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Cart with pagination");
        return setPageResponse.pageResponse(carts);
    }

    @Override
    public Cart getCartById(String id) {
        log.info("Finding Cart With Id: {}", id);
        return cartRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Cart with id %s not found", id)));
    }

    @Override
    public Cart saveCart(Cart cart) {
        log.info("Saving Cart {}", cart);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(String id, Cart cart) {
        Cart oldCart = cartRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Cart with id %s not found", id)));
        log.info("Updating Cart {}", cart);
        oldCart.setUserId(cart.getUserId());
        oldCart.setProductIds(cart.getProductIds());
        return cartRepository.save(oldCart);
    }

    @Override
    public boolean deleteCart(String id) {
        log.info("Deleting Cart with email {}", id);
        Cart delete = cartRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Cart with id %s not found", id)));
        cartRepository.delete(delete);
        return Boolean.TRUE;
    }
}
