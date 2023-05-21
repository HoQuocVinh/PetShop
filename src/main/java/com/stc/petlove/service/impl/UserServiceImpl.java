package com.stc.petlove.service.impl;

import com.stc.petlove.entities.User;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.UserRepository;
import com.stc.petlove.service.SetPageResponse;
import com.stc.petlove.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SetPageResponse<User> setPageResponse;


    @Override
    public PageResponse getAllUser(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<User> users = userRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All User with pagination");
        return setPageResponse.pageResponse(users);
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("Finding User With Email: {}", email);
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(String.format("User with email %s not found", email)));
    }

    @Override
    public User getUserById(String id) {
        log.info("Finding User With Id: {}", id);
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id)));
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving User {}", user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id)));
        log.info("Updating User {}", user);
        oldUser.setEmail(user.getEmail());
        oldUser.setUserName(user.getUserName());
        oldUser.setFullName(user.getFullName());
        oldUser.setAddress(user.getAddress());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    @Override
    public boolean deleteUser(String email) {
        log.info("Deleting User with email {}", email);
        User delete = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(String.format("User with email %s not found", email)));
        userRepository.delete(delete);
        return Boolean.TRUE;
    }
}
