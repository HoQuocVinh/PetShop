package com.stc.petlove.service;

import com.stc.petlove.entities.Category;
import com.stc.petlove.payload.PageResponse;

public interface CategoryService {
    PageResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir);
    Category getCategoryById(String id);
    Category saveCategory(Category category);
    Category updateCategory(String id, Category category);
    boolean deleteCategory(String id);
}
