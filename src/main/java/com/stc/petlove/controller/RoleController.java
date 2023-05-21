package com.stc.petlove.controller;

import com.stc.petlove.entities.Role;
import com.stc.petlove.payload.ApiResponse;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.service.RoleService;
import com.stc.petlove.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoleController extends AbstractRestController{
    private final RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<ApiResponse> getAllRole(
            @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false)
            int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false)
            int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "roleName", required = false)
            String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false)
            String sortDir
    ){
        ApiResponse<PageResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(roleService.getAllRole(pageNo, pageSize, sortBy, sortDir));
        apiResponse.setMessage("Get All Role success!");
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/role/{id}")
    public ResponseEntity<ApiResponse> getRoleById(@PathVariable("id")String id){
        ApiResponse<Role> apiResponse = new ApiResponse<>();
        apiResponse.setResult(roleService.getRoleById(id));
        apiResponse.setMessage(String.format("Get Role with id: %s",id));
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/role/create")
    public ResponseEntity<ApiResponse> saveRole(@RequestBody Role role){
    ApiResponse<Role> apiResponse = new ApiResponse<>();
    apiResponse.setResult(roleService.saveRole(role));
    apiResponse.setMessage("Save Role success!");
    return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/role/{id}/update")
    public ResponseEntity<ApiResponse> updateRole(@PathVariable("id")String id, @RequestBody Role role){
        ApiResponse<Role> apiResponse = new ApiResponse<>();
        apiResponse.setResult(roleService.updateRole(id,role));
        apiResponse.setMessage("Update Role success!");
        return ResponseEntity.ok().body(apiResponse);
    }

}
