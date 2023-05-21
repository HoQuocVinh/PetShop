package com.hcmute.vinh19110318.controller;

import com.hcmute.vinh19110318.entities.Order;
import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.payload.ApiResponse;
import com.hcmute.vinh19110318.service.OrderService;
import com.hcmute.vinh19110318.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController extends AbstractRestController{
    private final OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<ApiResponse> getAllOrder(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "cartId", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        ApiResponse<PageResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.getAllOrder(pageNo, pageSize, sortBy, sortDir));
        apiResponse.setMessage("Get all Order success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/order/{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable("id")String id){
        ApiResponse<Order> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.getOrderById(id));
        apiResponse.setMessage(String.format("Get Order with id: %s", id));
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/order")
    public ResponseEntity<ApiResponse> saveOrder(@RequestBody Order order){
        ApiResponse<Order> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.saveOrder(order));
        apiResponse.setMessage("Save Order success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/order/{id}/udpate")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable("id")String id, @RequestBody Order order){
        ApiResponse<Order> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.updateOrder(id, order));
        apiResponse.setMessage("Update Order success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @DeleteMapping("/order/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("id")String id){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        apiResponse.setResult(orderService.deleteOrder(id));
        apiResponse.setMessage("Delete Order success!");
        return ResponseEntity.ok().body(apiResponse);
    }
}
