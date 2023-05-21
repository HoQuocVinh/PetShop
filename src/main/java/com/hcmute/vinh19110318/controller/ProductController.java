package com.hcmute.vinh19110318.controller;

import com.hcmute.vinh19110318.entities.Product;
import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.payload.ApiResponse;
import com.hcmute.vinh19110318.service.ProductService;
import com.hcmute.vinh19110318.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController extends AbstractRestController{
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ApiResponse> getAllProduct(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "productName", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        ApiResponse<PageResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProduct(pageNo, pageSize, sortBy, sortDir));
        apiResponse.setMessage("Get All Product success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("id")String id){
        ApiResponse<Product> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getProductById(id));
        apiResponse.setMessage(String.format("Get Product with id: %s",id));
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/product")
    public ResponseEntity<ApiResponse> saveProduct(@RequestBody Product product){
        ApiResponse<Product> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.saveProduct(product));
        apiResponse.setMessage("Save Product success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/product/{id}/update")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id")String id, @RequestBody Product product){
        ApiResponse<Product> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(id, product));
        apiResponse.setMessage("Update Product success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id")String id){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.deleteProduct(id));
        apiResponse.setMessage("Delete Product success!");
        return ResponseEntity.ok().body(apiResponse);
    }
}
