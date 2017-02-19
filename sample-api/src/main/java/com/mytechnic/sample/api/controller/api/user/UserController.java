package com.mytechnic.sample.api.controller.api.user;

import com.mytechnic.sample.api.controller.api.ApiResponse;
import com.mytechnic.sample.api.request.UserCreateRequest;
import com.mytechnic.sample.api.request.UserUpdateRequest;
import com.mytechnic.sample.api.response.UserCreateResponse;
import com.mytechnic.sample.api.response.UserExistsResponse;
import com.mytechnic.sample.api.response.UserResponse;
import com.mytechnic.sample.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Api(description = "사용자 관리")
@RestController
@RequestMapping("/api/account/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "사용자 등록")
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ApiResponse<UserCreateResponse> createUser(UserCreateRequest userCreateRequest) {
        return ApiResponse.succcess(userService.createUser(userCreateRequest));
    }

    @ApiOperation(value = "사용자 수정")
    @RequestMapping(path = "/{userId}", method = RequestMethod.PUT)
    public ApiResponse<UserCreateResponse> updateUser(
            @ApiParam(value = "사용자 ID", required = true, example = "1") @PathVariable Integer userId,
            UserUpdateRequest userUpdateRequest
    ) {
        userService.updateUser(userId, userUpdateRequest);
        return ApiResponse.succcess();
    }

    @ApiOperation(value = "사용자 조회")
    @RequestMapping(path = "/{userid}", method = RequestMethod.GET)
    public ApiResponse<UserResponse> getUserByUserId(@PathVariable Integer userid) {
        return ApiResponse.succcess(userService.getUser(userid));
    }

    @ApiOperation(value = "사용자 조회 (이메일 이용)")
    @RequestMapping(path = "/email/{email:.+}", method = RequestMethod.GET)
    public ApiResponse<UserResponse> getUserByEmail(@PathVariable String email) {
        return ApiResponse.succcess(userService.getUserByEmail(email));
    }

    @ApiOperation(value = "사용자 존재 유무")
    @RequestMapping(path = "/email/{email}/exist", method = RequestMethod.GET)
    public ApiResponse<UserExistsResponse> validate(@PathVariable String email) {
        return ApiResponse.succcess(userService.getUserExists(email));
    }
}
