package com.stc.petlove.service.impl;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.LoaiThuCungRepository;
import com.stc.petlove.service.LoaiThuCungService;
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
public class LoaiThuCungServiceImpl implements LoaiThuCungService {
    private final LoaiThuCungRepository loaiThuCungRepository;
    private final SetPageResponse<LoaiThuCung> setPageResponse;
    @Override
    public LoaiThuCung save(LoaiThuCung loaiThuCung) {
        log.info("Saving Loai Thu Cung: {}", loaiThuCung.toString());
        return loaiThuCungRepository.save(loaiThuCung);
    }

    @Override
    public LoaiThuCung update(LoaiThuCung loaiThuCung) {
        LoaiThuCung update = new LoaiThuCung();
        update.setMaLoaiThuCung(loaiThuCung.getMaLoaiThuCung());
        update.setTenLoaiThuCung(loaiThuCung.getTenLoaiThuCung());
        update.setTrangThai(loaiThuCung.isTrangThai());
        log.info("Updating Loai Thu Cung: {}", update.toString());
        return loaiThuCungRepository.save(update);
    }

    @Override
    public void delete(String id) {
        LoaiThuCung delete = loaiThuCungRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Loai thu cung with id {} not found", id)));
        log.info("Deleting Loai Thu Cung with ID: {}", id);
        loaiThuCungRepository.delete(delete);

    }

    @Override
    public LoaiThuCung findById(String id) {
        log.info("Finding Loai Thu Cung with ID: {}",id);
        return loaiThuCungRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Loai thu cung with id {} not found", id)));
    }

    @Override
    public PageResponse getAllLoaiThuCung(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<LoaiThuCung> loaiThuCungs = loaiThuCungRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Loai Thu Cung with pagination");
        return setPageResponse.pageResponse(loaiThuCungs);
    }
}
