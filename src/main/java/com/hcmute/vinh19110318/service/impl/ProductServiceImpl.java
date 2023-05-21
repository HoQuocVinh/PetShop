package com.hcmute.vinh19110318.service.impl;

import com.hcmute.vinh19110318.entities.Product;
import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.repository.ProductRepository;
import com.hcmute.vinh19110318.exception.NotFoundException;
import com.hcmute.vinh19110318.service.ProductService;
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
