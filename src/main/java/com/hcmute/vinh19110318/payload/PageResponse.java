package com.hcmute.vinh19110318.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
    private List<?> data;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last = false;
}
