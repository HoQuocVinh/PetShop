package com.stc.petlove.service.impl;

import com.stc.petlove.entities.Product;
import com.stc.petlove.entities.Role;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.ProductRepository;
import com.stc.petlove.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SetPageResponse<Product> setPageResponse;
    @Override
    public PageResponse getAllProduct(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<Product> products  = productRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Product with pagination");
        return setPageResponse.pageResponse(products);
    }

    @Override
    public Product getProductById(String id) {
        log.info("Finding Product With Id: {}", id);
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Product with id %s not found", id)));
    }

    @Override
    public Product saveProduct(Product product) {
        log.info("Saving Product {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product oldProduct = productRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Product with id %s not found", id)));
        log.info("Updating Product {}", product);
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setCategoryId(product.getCategoryId());
        oldProduct.setPrice(product.getPrice());
        return productRepository.save(oldProduct);
    }

    @Override
    public boolean deleteProduct(String id) {
        log.info("Deleting Product with id {}", id);
        Product delete = productRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Product with id %s not found", id)));
        productRepository.delete(delete);
        return Boolean.TRUE;
    }
}
