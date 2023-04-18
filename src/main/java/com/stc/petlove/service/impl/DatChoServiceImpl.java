package com.stc.petlove.service.impl;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.DatChoRepository;
import com.stc.petlove.service.DatChoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DatChoServiceImpl implements DatChoService {
    private final SetPageResponseImpl<DatCho> setPageResponse;
    private final DatChoRepository datChoRepository;

    @Override
    public DatCho findById(String id) {
        log.info("Finding Dat Cho With Id: {}", id);
        return datChoRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Location with id %s not found", id)));
    }

    @Override
    public DatCho findByEmail(String email) {
        log.info("Finding Dat Cho With Email: {}", email);
        return datChoRepository.findDatChoByEmail(email).orElseThrow(() -> new NotFoundException(String.format("Location with email %s not found", email)));
    }

    @Override
    public DatCho save(DatCho datCho) {
        log.info("Saving datCho {}", datCho);
        return datChoRepository.save(datCho);
    }

    @Override
    public DatCho update(DatCho datCho) {
        log.info("Updating Dat cho {}", datCho);
        DatCho update = new DatCho();
        update.setEmail(datCho.getEmail());
        update.setCanDan(datCho.getCanDan());
        update.setThongTinDatChos(datCho.getThongTinDatChos());
        update.setTrangThaiDatCho(datCho.getTrangThaiDatCho());
        update.setTrangThai(datCho.isTrangThai());
        update.setThoiGian(datCho.getThoiGian());
        return datChoRepository.save(update);
    }

    @Override
    public Boolean deleteDatCho(String id) {
        log.info("Deleting Dat Cho with id {}", id);
        DatCho delete = datChoRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Location with id %s not found", id)));
        datChoRepository.delete(delete);
        return Boolean.TRUE;
    }

    @Override
    public PageResponse getAllDatCho(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<DatCho> datChos = datChoRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Dat Cho with pagination");
        return setPageResponse.pageResponse(datChos);
    }
}
