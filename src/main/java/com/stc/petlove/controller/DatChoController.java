package com.stc.petlove.controller;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.DatChoService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatChoController extends AbstractRestController {
    private final DatChoService datChoService;

    @GetMapping("/dat-chos")
    public ResponseEntity<PageResponse> getAllDatCho(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "email", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir) throws InterruptedException {
        return ResponseEntity.ok().body(datChoService.getAllDatCho(pageNo, pageSize, sortBy, sortDir));
    }

    @PostMapping("/dat-cho")
    public ResponseEntity<DatCho> saveDatcho(@RequestBody DatCho datCho) {
        return ResponseEntity.ok().body(datChoService.save(datCho));
    }

    @PutMapping("/dat-cho")
    public ResponseEntity<DatCho> updateDatCho(@RequestBody DatCho datCho) {
        return ResponseEntity.ok().body(datChoService.update(datCho));
    }

    @GetMapping("/dat-cho/{id}")
    public ResponseEntity<DatCho> findDatChoById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(datChoService.findById(id));
    }

    @DeleteMapping("/dat-cho/{id}")
    public ResponseEntity<?> deleteDatCho(@PathVariable("id") String id) {
        datChoService.deleteDatCho(id);
        return ResponseEntity.ok().body("Deleted successfully!");

    }

    @GetMapping("/dat-cho/email")
    public ResponseEntity<DatCho> getDatChoByEmail(@RequestBody String email) {
        return ResponseEntity.ok().body(datChoService.findByEmail(email));
    }
}
