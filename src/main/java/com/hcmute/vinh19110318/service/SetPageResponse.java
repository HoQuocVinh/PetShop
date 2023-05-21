package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.payload.PageResponse;
import org.springframework.data.domain.Page;

/**
 * Create by: IntelliJ IDEA
 *
 * @author : ThanhTrong
 * @mailto : ntt.thanhtrong@gmail.com
 * @created : 5/15/2023, Monday
 * @filename : SetPageResponse
 **/
public interface SetPageResponse<T> {
    public PageResponse pageResponse(Page<T> list);
}
