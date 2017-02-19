package com.mytechnic.sample.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Builder
@Getter
public class UserExistsResponse {

    @ApiModelProperty(value = "유저 존재 유무", example = "true")
    private Boolean exists;
}
