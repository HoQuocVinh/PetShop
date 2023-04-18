package com.stc.petlove.service;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.payload.PageResponse;

public interface LoaiThuCungService {
    LoaiThuCung save(LoaiThuCung loaiThuCung);
    LoaiThuCung update(LoaiThuCung loaiThuCung);
    void delete(String id);
    LoaiThuCung findById(String id);
    PageResponse getAllLoaiThuCung(int pageNo, int pageSize, String sortBy, String sortDir);
}
