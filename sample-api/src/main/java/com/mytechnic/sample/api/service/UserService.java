package com.mytechnic.sample.api.service;

import com.mytechnic.sample.api.request.UserCreateRequest;
import com.mytechnic.sample.api.request.UserUpdateRequest;
import com.mytechnic.sample.api.response.UserCreateResponse;
import com.mytechnic.sample.api.response.UserExistsResponse;
import com.mytechnic.sample.api.response.UserResponse;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
public interface UserService {

    @Transactional
    UserCreateResponse createUser(UserCreateRequest userCreateRequest);

    @Transactional
    void updateUser(Integer userId, UserUpdateRequest userUpdateRequest);

    @Transactional(readOnly = true)
    UserResponse getUser(Integer userId);

    @Transactional(readOnly = true)
    UserResponse getUserByEmail(String email);

    @Transactional(readOnly = true)
    UserExistsResponse getUserExists(String email);
}
