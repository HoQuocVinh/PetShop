package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.User;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface UserService {
    PageResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir);
    User getUserByEmail(String email);
    User getUserById(String id);
    User saveUser(User user);
    User updateUser(String id, User user);
    boolean deleteUser(String email);
}
