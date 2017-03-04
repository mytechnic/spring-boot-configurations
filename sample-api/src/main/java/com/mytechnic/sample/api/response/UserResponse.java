package com.mytechnic.sample.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.20.
 */
@Builder
@Getter
public class UserResponse {

	@ApiModelProperty(value = "유저 ID", example = "1")
	private Integer userId;

	@ApiModelProperty(value = "유저 등급 코드", example = "USER")
	private String grade;

	@ApiModelProperty(value = "유저 등급명", example = "유저")
	private String gradeTitle;

	@ApiModelProperty(value = "유저 상태 코드", example = "NORMAL")
	private String status;

	@ApiModelProperty(value = "유저 상태명", example = "정상")
	private String statusTitle;

	@ApiModelProperty(value = "이메일 주소", example = "sample@locahost.com")
	private String email;

	@ApiModelProperty(value = "성별 코드", example = "MALE")
	private String gender;

	@ApiModelProperty(value = "성별 코드명", example = "남자")
	private String genderTitle;
}
