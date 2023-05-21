package com.stc.petlove.service;

import com.stc.petlove.entities.User;
import com.stc.petlove.payload.PageResponse;

import java.util.List;

public interface UserService {
    PageResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir);
    User getUserByEmail(String email);
    User getUserById(String id);
    User saveUser(User user);
    User updateUser(String id, User user);
    boolean deleteUser(String email);
}
