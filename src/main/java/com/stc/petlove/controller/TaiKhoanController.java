package com.stc.petlove.controller;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.TaiKhoanService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaiKhoanController extends AbstractRestController {

  private final TaiKhoanService taiKhoanService;

  @GetMapping("/tai-khoans")
  public ResponseEntity<PageResponse> getAllTaiKhoan(
    @RequestParam(
      value = "pageNo",
      defaultValue = Constants.DEFAULT_PAGE_NUMBER,
      required = false
    ) int pageNo,
    @RequestParam(
      value = "pageSize",
      defaultValue = Constants.DEFAULT_PAGE_SIZE,
      required = false
    ) int pageSize,
    @RequestParam(
      value = "sortBy",
      defaultValue = "maLoaiThuCung",
      required = false
    ) String sortBy,
    @RequestParam(
      value = "sortDir",
      defaultValue = Constants.DEFAULT_SORT_DIRECTION,
      required = false
    ) String sortDir
  ) {
    return ResponseEntity
      .ok()
      .body(taiKhoanService.getAllTaiKhoan(pageNo, pageSize, sortBy, sortDir));
  }

  @PostMapping("/tai-khoan")
  public ResponseEntity<TaiKhoan> saveTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
    return ResponseEntity.ok().body(taiKhoanService.save(taiKhoan));
  }

  @PutMapping("/tai-khoan")
  public ResponseEntity<TaiKhoan> updateTaiKhoan(
    @RequestBody TaiKhoan taiKhoan
  ) {
    return ResponseEntity.ok().body(taiKhoanService.update(taiKhoan));
  }

  @DeleteMapping("/tai-khoan/{id}")
  public ResponseEntity<?> deleteTaiKhoan(@PathVariable("id") String id) {
    taiKhoanService.delete(id);
    return ResponseEntity.ok().body("Deleted Tai Khoan successfully");
  }

  @GetMapping("/tai-khoan/{id}")
  public ResponseEntity<TaiKhoan> findTaiKhoanById(
    @PathVariable("id") String id
  ) {
    return ResponseEntity.ok().body(taiKhoanService.findById(id));
  }
}
