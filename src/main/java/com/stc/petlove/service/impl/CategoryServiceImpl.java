package com.stc.petlove.service.impl;

import com.stc.petlove.entities.Category;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.CategoryRepository;
import com.stc.petlove.service.CategoryService;
import com.stc.petlove.service.SetPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final SetPageResponse<Category> setPageResponse;
    @Override
    public PageResponse getAllCategory(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<Category> categories  = categoryRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Category with pagination");
        return setPageResponse.pageResponse(categories);
    }

    @Override
    public Category getCategoryById(String id) {
        log.info("Finding Category With Id: {}", id);
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Category with id %s not found", id)));
    }

    @Override
    public Category saveCategory(Category category) {
        log.info("Saving Category {}", category);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(String id, Category category) {
        Category oldCategory = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Category with id %s not found", id)));
        log.info("Updating Category {}", category);
        oldCategory.setCategoryName(category.getCategoryName());
        return categoryRepository.save(oldCategory);
    }

    @Override
    public boolean deleteCategory(String id) {
        log.info("Deleting Category with id {}", id);
        Category delete = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Category with id %s not found", id)));
        categoryRepository.delete(delete);
        return Boolean.TRUE;
    }
}
