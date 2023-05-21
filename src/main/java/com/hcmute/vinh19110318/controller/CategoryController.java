package com.hcmute.vinh19110318.controller;

import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.entities.Category;
import com.hcmute.vinh19110318.payload.ApiResponse;
import com.hcmute.vinh19110318.service.CategoryService;
import com.hcmute.vinh19110318.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController extends AbstractRestController{
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<ApiResponse> getAllCategory(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "categoryName", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        ApiResponse<PageResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.getAllCategory(pageNo,pageSize,sortBy,sortDir));
        apiResponse.setMessage("Get all Category successfully!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable("id")String id){
        ApiResponse<Category> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.getCategoryById(id));
        apiResponse.setMessage(String.format("Get Category with Id: %s", id));
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/category/save")
    public ResponseEntity<ApiResponse> saveCategory(@RequestBody Category category){
        ApiResponse<Category> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.saveCategory(category));
        apiResponse.setMessage("Save category success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/category/{id}/update")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("id")String id,@RequestBody Category category){
    ApiResponse<Category> apiResponse = new ApiResponse<>();
    apiResponse.setResult(categoryService.updateCategory(id, category));
    apiResponse.setMessage("Update Category success!");
    return ResponseEntity.ok().body(apiResponse);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id")String id){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        apiResponse.setResult(categoryService.deleteCategory(id));
        apiResponse.setMessage("Delete Category success!");
        return ResponseEntity.ok().body(apiResponse);
    }
}
