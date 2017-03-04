package com.mytechnic.sample.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@Getter
public class BusinessException extends RuntimeException {
	private HttpStatus httpStatus;
	private String code;
	private String message;

	public BusinessException(BusinessExceptionCode businessExceptionCode) {
		this.httpStatus = businessExceptionCode.getHttpStatus();
		this.code = businessExceptionCode.name();
		this.message = businessExceptionCode.getMessage();
	}

	public BusinessException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.code = httpStatus.name();
		this.message = httpStatus.getReasonPhrase();
	}
}
