package com.stc.petlove.service;

import com.stc.petlove.payload.PageResponse;
import org.springframework.data.domain.Page;

public interface SetPageResponse<T> {
    PageResponse pageResponse(Page<T> list);
}
