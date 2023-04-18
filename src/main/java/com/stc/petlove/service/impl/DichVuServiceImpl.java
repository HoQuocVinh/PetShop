package com.stc.petlove.service.impl;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.DichVuRepository;
import com.stc.petlove.service.DichVuService;
import com.stc.petlove.service.SetPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DichVuServiceImpl implements DichVuService {
    private final DichVuRepository dichVuRepository;
    private final SetPageResponse<DichVu> setPageResponse;

    @Override
    public DichVu save(DichVu dichVu) {
        log.info("Saving Dich Vu: {}", dichVu.toString());
        return dichVuRepository.save(dichVu);
    }

    @Override
    public DichVu update(DichVu dichVu) {
        DichVu update = new DichVu();
        update.setMaDichVu(dichVu.getMaDichVu());
        update.setTrangThai(dichVu.isTrangThai());
        update.setTenDichVu(dichVu.getTenDichVu());
        update.setNoiDung(dichVu.getNoiDung());
        update.setGiaDichVus(dichVu.getGiaDichVus());
        log.info("Updating Dich Vu: {}", update.toString());
        return dichVuRepository.save(update);
    }

    @Override
    public void delete(String id) {
        DichVu delete = dichVuRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Dich Vu with id {} not found", id)));
        log.info("Deleting Dich Vu with ID: {}", id);
        dichVuRepository.delete(delete);
    }

    @Override
    public DichVu findById(String id) {
        log.info("Finding Dich Vu with ID: {}", id);
        return dichVuRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Dich Vu with id {} not found", id)));
    }

    @Override
    public PageResponse getAllDichVu(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<DichVu> dichVus = dichVuRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Dich Vu with pagination");
        return setPageResponse.pageResponse(dichVus);
    }
}
