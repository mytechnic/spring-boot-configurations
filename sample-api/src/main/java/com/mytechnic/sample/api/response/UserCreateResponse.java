package com.mytechnic.sample.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Builder
@Getter
public class UserCreateResponse {

    @ApiModelProperty(value = "유저 ID", example = "1")
    private Integer userId;
}
