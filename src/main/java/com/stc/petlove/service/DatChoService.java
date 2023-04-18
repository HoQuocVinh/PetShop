package com.stc.petlove.service;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.payload.PageResponse;

public interface DatChoService {
    DatCho findById(String id);
    DatCho findByEmail(String email);
    DatCho save(DatCho datCho);
    DatCho update(DatCho datCho);
    Boolean deleteDatCho(String id);
    PageResponse getAllDatCho(int pageNo, int pageSize, String sortBy, String sortDir);

}
