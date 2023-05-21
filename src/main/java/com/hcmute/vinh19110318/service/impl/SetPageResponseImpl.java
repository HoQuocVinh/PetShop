package com.hcmute.vinh19110318.service.impl;

import com.hcmute.vinh19110318.payload.PageResponse;
import com.hcmute.vinh19110318.service.SetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Create by: IntelliJ IDEA
 *
 * @author : ThanhTrong
 * @mailto : ntt.thanhtrong@gmail.com
 * @created : 5/15/2023, Monday
 * @filename : SetPageResponseImpl
 **/
@Service
public class SetPageResponseImpl<T> implements SetPageResponse<T> {
    @Override
    public PageResponse pageResponse(Page<T> list) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setData(list.getContent());
        pageResponse.setPageNo(list.getNumber());
        pageResponse.setPageSize(list.getSize());
        pageResponse.setTotalElements(list.getTotalElements());
        pageResponse.setTotalPages(list.getTotalPages());
        pageResponse.setLast(list.isLast());
        return pageResponse;
    }
}
