package com.stc.petlove.service;

import com.stc.petlove.entities.Role;
import com.stc.petlove.payload.PageResponse;

import java.util.List;

public interface RoleService {
    PageResponse getAllRole(int pageNo, int pageSize, String sortBy, String sortDir);
    Role getRoleById(String id);
    Role getRoleByRoleName(String roleName);
    Role saveRole(Role role);
    Role updateRole(String id, Role role);
    boolean deleteRole(String id);
}
