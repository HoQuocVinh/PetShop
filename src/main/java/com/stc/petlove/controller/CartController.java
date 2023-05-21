package com.stc.petlove.controller;

import com.stc.petlove.entities.Cart;
import com.stc.petlove.payload.ApiResponse;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.CartService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CartController extends AbstractRestController{
    private final CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<ApiResponse> getAllCart(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "userId", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        ApiResponse<PageResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartService.getAllCart(pageNo, pageSize, sortBy, sortDir));
        apiResponse.setMessage("Get all Cart successfully!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/cart/{id}")
    public ResponseEntity<ApiResponse> getCartById(@PathVariable("id") String id){
        ApiResponse<Cart> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartService.getCartById(id));
        apiResponse.setMessage(String.format("Get Cart with id: %s", id));
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/cart/save")
    public ResponseEntity<ApiResponse> saveCart(@RequestBody Cart cart){
        ApiResponse<Cart> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartService.saveCart(cart));
        apiResponse.setMessage("Save Cart successfully!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/cart/{id}/update")
    public ResponseEntity<ApiResponse> updateCart(@PathVariable("id") String id, @RequestBody Cart cart){
        ApiResponse<Cart> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartService.updateCart(id, cart));
        apiResponse.setMessage("Update Cart successfully!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @DeleteMapping("/cart/{id}")
    public ResponseEntity<ApiResponse> deleteCart(@PathVariable("id")String id){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        apiResponse.setResult(cartService.deleteCart(id));
        apiResponse.setMessage("Delete Cart successfully!");
        return ResponseEntity.ok().body(apiResponse);
    }
}
