package com.stc.petlove.service.impl;

import com.stc.petlove.entities.Role;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.RoleRepository;
import com.stc.petlove.service.RoleService;
import com.stc.petlove.service.SetPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final SetPageResponse<Role> setPageResponse;
    @Override
    public PageResponse getAllRole(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<Role> roles  = roleRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Role with pagination");
        return setPageResponse.pageResponse(roles);
    }

    @Override
    public Role getRoleById(String id) {
        log.info("Finding Role With Id: {}", id);
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Role with id %s not found", id)));
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName).orElse(null);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving Role {}", role);
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(String id, Role role) {
        Role oldRole = roleRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Role with id %s not found", id)));
        log.info("Updating Role {}", role);
        oldRole.setRoleName(role.getRoleName());
        return roleRepository.save(oldRole);
    }

    @Override
    public boolean deleteRole(String id) {
        log.info("Deleting Role with id {}", id);
        Role delete = roleRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Role with id %s not found", id)));
        roleRepository.delete(delete);
        return Boolean.TRUE;
    }
}
