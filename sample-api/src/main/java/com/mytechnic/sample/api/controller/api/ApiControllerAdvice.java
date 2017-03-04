package com.mytechnic.sample.api.controller.api;

import com.mytechnic.sample.api.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@RestControllerAdvice(basePackageClasses = ApiControllerAdvice.class)
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ApiResponse<BusinessException> businessException(HttpServletResponse response, BusinessException e) {
		response.setStatus(e.getHttpStatus().value());
		return ApiResponse.error(e);
	}
}