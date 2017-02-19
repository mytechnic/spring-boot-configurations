package com.mytechnic.sample.api.service;

import com.mytechnic.sample.api.exception.BusinessException;
import com.mytechnic.sample.api.exception.BusinessExceptionCode;
import com.mytechnic.sample.api.request.UserCreateRequest;
import com.mytechnic.sample.api.request.UserUpdateRequest;
import com.mytechnic.sample.api.response.UserCreateResponse;
import com.mytechnic.sample.api.response.UserExistsResponse;
import com.mytechnic.sample.api.response.UserResponse;
import com.mytechnic.sample.persistence.mapper.UserMapper;
import com.mytechnic.sample.persistence.mapper.dto.UserDto;
import com.mytechnic.sample.persistence.repository.UserRepository;
import com.mytechnic.sample.persistence.repository.entity.UserEntity;
import com.mytechnic.sample.persistence.type.UserGrade;
import com.mytechnic.sample.persistence.type.UserStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {

        UserEntity user = UserEntity.builder()
                .grade(UserGrade.USER)
                .status(UserStatus.NORMAL)
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getPassword())
                .gender(userCreateRequest.getGender())
                .created(LocalDateTime.now())
                .build();
        userRepository.save(user);

        return UserCreateResponse.builder().userId(user.getUserId()).build();
    }

    @Override
    public void updateUser(Integer userId, UserUpdateRequest userUpdateRequest) {

        UserEntity user = userRepository.findOne(userId);
        user.setEmail(userUpdateRequest.getEmail());
        user.setGender(userUpdateRequest.getGender());
        user.setUpdated(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public UserResponse getUser(Integer userId) {

        UserDto user = userMapper.findOne(userId);

        if (user == null) {
            throw new BusinessException(BusinessExceptionCode.USER_NOT_FOUND);
        }

        return UserResponse.builder()
                .userId(user.getUserId())
                .grade(user.getGrade().name())
                .gradeTitle(user.getGrade().getTitle())
                .status(user.getStatus().name())
                .statusTitle(user.getStatus().getTitle())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .genderTitle(user.getGender().getTitle())
                .build();
    }

    @Override
    public UserResponse getUserByEmail(String email) {

        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            throw new BusinessException(BusinessExceptionCode.USER_NOT_FOUND);
        }

        return UserResponse.builder()
                .userId(user.getUserId())
                .grade(user.getGrade().name())
                .gradeTitle(user.getGrade().getTitle())
                .status(user.getStatus().name())
                .statusTitle(user.getStatus().getTitle())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .genderTitle(user.getGender().getTitle())
                .build();
    }

    @Override
    public UserExistsResponse getUserExists(String email) {
        return UserExistsResponse.builder().exists(userRepository.getUserExists(email) > 0L).build();
    }
}
