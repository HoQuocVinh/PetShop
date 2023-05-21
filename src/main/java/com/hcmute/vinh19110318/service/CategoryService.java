package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.Category;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface CategoryService {
    PageResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);
    Category getCategoryById(String id);
    Category saveCategory(Category category);
    Category updateCategory(String id, Category category);
    boolean deleteCategory(String id);
}
