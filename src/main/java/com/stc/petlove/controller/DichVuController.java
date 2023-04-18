package com.stc.petlove.controller;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.DichVuService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DichVuController extends AbstractRestController {
    private final DichVuService dichVuService;

    @GetMapping("/dich-vus")
    public ResponseEntity<PageResponse> getAllDichVu(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "maDichVu", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        return ResponseEntity.ok().body(dichVuService.getAllDichVu(pageNo,pageSize,sortBy,sortDir));
    }
    @GetMapping("/dich-vu/{id}")
    public ResponseEntity<DichVu> findDichVuByID(@PathVariable("id")String id){
        return ResponseEntity.ok().body(dichVuService.findById(id));
    }
    @PostMapping("/dich-vu")
    public ResponseEntity<DichVu> saveDichVu(@RequestBody DichVu dichVu){
        return ResponseEntity.ok().body(dichVuService.save(dichVu));
    }

    @PutMapping("/dich-vu")
    public ResponseEntity<DichVu> updateDichVu(@RequestBody DichVu dichVu){
        return ResponseEntity.ok().body(dichVuService.update(dichVu));
    }
    @DeleteMapping("/dich-vu/{id}")
    public ResponseEntity<?> deleteDichVu(@PathVariable("id")String id){
        dichVuService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully!");
    }
}
