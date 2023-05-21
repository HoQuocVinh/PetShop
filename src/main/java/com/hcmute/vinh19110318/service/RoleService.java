package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.Role;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface RoleService {
    PageResponse getAllRole(int pageNo, int pageSize, String sortBy, String sortDir);
    Role getRoleById(String id);
    Role getRoleByRoleName(String roleName);
    Role saveRole(Role role);
    Role updateRole(String id, Role role);
    boolean deleteRole(String id);
}
