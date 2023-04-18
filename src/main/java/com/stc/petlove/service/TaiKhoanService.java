package com.stc.petlove.service;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.payload.PageResponse;

public interface TaiKhoanService {
    TaiKhoan save(TaiKhoan taikhoan);
    TaiKhoan update(TaiKhoan taikhoan);
    void delete(String id);
    TaiKhoan findById(String id);
    PageResponse getAllTaiKhoan(int pageNo, int pageSize, String sortBy, String sortDir);
}
