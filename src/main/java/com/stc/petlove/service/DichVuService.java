package com.stc.petlove.service;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.payload.PageResponse;

public interface DichVuService {
    DichVu save(DichVu dichVu);
    DichVu update(DichVu dichVu);
    void delete(String id);
    DichVu findById(String id);
    PageResponse getAllDichVu(int pageNo, int pageSize, String sortBy, String sortDir);
}
