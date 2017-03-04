package com.mytechnic.sample.api.request;

import com.mytechnic.sample.persistent.type.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@ApiModel(description = "유저 가입")
@Getter
@Setter
public class UserCreateRequest {

	@ApiModelProperty(value = "이메일 주소", required = true, example = "sample@locahost.com")
	@NonNull
	private String email;

	@ApiModelProperty(value = "비밀번호", required = true, example = "1234")
	@NonNull
	private String password;

	@ApiModelProperty(value = "성별 코드", required = true, example = "MALE")
	@NonNull
	private Gender gender;
}
