package com.mytechnic.sample.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@Getter
public enum BusinessExceptionCode {
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;

	BusinessExceptionCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
