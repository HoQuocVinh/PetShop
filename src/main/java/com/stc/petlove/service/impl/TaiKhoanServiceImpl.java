package com.stc.petlove.service.impl;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.TaiKhoanRepository;
import com.stc.petlove.service.SetPageResponse;
import com.stc.petlove.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;
    private final SetPageResponse<TaiKhoan> setPageResponse;
    @Override
    public TaiKhoan save(TaiKhoan taikhoan) {
        log.info("Saving Tai Khoan: {}", taikhoan.toString());
        return taiKhoanRepository.save(taikhoan);
    }

    @Override
    public TaiKhoan update(TaiKhoan taiKhoan) {
        TaiKhoan update = new TaiKhoan();
        update.setName(taiKhoan.getName());
        update.setEmail(taiKhoan.getEmail());
        update.setDienThoai(taiKhoan.getDienThoai());
        update.setTrangThai(taiKhoan.isTrangThai());
        log.info("Updating Tai Khoan: {}", update.toString());
        return taiKhoanRepository.save(update);
    }

    @Override
    public void delete(String id) {
        TaiKhoan delete = taiKhoanRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Khong tim thay tai khoan voi id: {}",id)));
        log.info("Deleting Tai Khoan voi ID: {}",id);
        taiKhoanRepository.delete(delete);
    }

    @Override
    public TaiKhoan findById(String id) {
        log.info("Finding Tai Khoan voi ID: {}",id);
        return taiKhoanRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Khong tim thay tai khoan voi id: {}",id)));
    }

    @Override
    public PageResponse getAllTaiKhoan(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<TaiKhoan> taiKhoans = taiKhoanRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Tai Khoan with Pagination");
        return setPageResponse.pageResponse(taiKhoans);
    }
}
