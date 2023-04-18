package com.stc.petlove.controller;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.LoaiThuCungService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LoaiThuCungController extends AbstractRestController {
    private final LoaiThuCungService loaiThuCungService;

    @GetMapping("/loai-thu-cungs")
    public ResponseEntity<PageResponse> getAllLoaiThuCung(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "maLoaiThuCung", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        return ResponseEntity.ok().body(loaiThuCungService.getAllLoaiThuCung(pageNo, pageSize, sortBy, sortDir));
    }
    @GetMapping("/loai-thu-cung/{id}")
    public ResponseEntity<LoaiThuCung> findLoaiThuCungById(@PathVariable("id")String id){
        return ResponseEntity.ok().body(loaiThuCungService.findById(id));
    }
    @PostMapping("/loai-thu-cung")
    public ResponseEntity<LoaiThuCung> saveLoaiThuCung(@RequestBody LoaiThuCung loaiThuCung){
        return ResponseEntity.ok().body(loaiThuCungService.save(loaiThuCung));
    }
    @PutMapping("/loai-thu-cung")
    public ResponseEntity<LoaiThuCung> updateLoaiThuCung(@RequestBody LoaiThuCung loaiThuCung){
        return ResponseEntity.ok().body(loaiThuCungService.update(loaiThuCung));
    }
    @DeleteMapping("/loai-thu-cung/{id}")
    public ResponseEntity<?> deleteLoaiThuCung(@PathVariable("id")String id){
        loaiThuCungService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully!");
    }
}
