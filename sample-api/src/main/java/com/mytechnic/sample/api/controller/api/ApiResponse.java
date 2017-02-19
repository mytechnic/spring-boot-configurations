package com.mytechnic.sample.api.controller.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytechnic.sample.api.exception.BusinessException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    @ApiModelProperty(value = "에러 발생 유무", example = "false")
    private boolean errorYn;

    @ApiModelProperty(value = "에러 내용")
    private Error error;

    @ApiModelProperty(value = "결과 데이터")
    private T data;

    public static <T> ApiResponse<T> succcess() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorYn(false);
        return response;
    }

    public static <T> ApiResponse<T> succcess(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorYn(false);
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorYn(true);
        return response;
    }

    public static <T> ApiResponse<T> error(BusinessException exception) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorYn(true);
        response.setError(
                Error.builder()
                        .httpCode(exception.getHttpStatus().name())
                        .httpCodeNumber(exception.getHttpStatus().value())
                        .httpCodeTitle(exception.getHttpStatus().getReasonPhrase())
                        .code(exception.getCode())
                        .message(exception.getMessage())
                        .build());
        return response;
    }

    public static <T> ApiResponse<T> error(BusinessException exception, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorYn(true);
        response.setError(
                Error.builder()
                        .httpCode(exception.getHttpStatus().name())
                        .httpCodeNumber(exception.getHttpStatus().value())
                        .httpCodeTitle(exception.getHttpStatus().getReasonPhrase())
                        .code(exception.getCode())
                        .message(exception.getMessage())
                        .build());
        response.setData(data);
        return response;
    }

    @Getter
    @Setter
    @Builder
    public static class Error {

        @ApiModelProperty(value = "에러 코드", example = "BAD_REQUEST")
        private String code;

        @ApiModelProperty(value = "에러 메시지", example = "요청이 잘못되었습니다.")
        private String message;

        @ApiModelProperty(value = "HTTP 코드", example = "BAD_REQUEST")
        private String httpCode;

        @ApiModelProperty(value = "HTTP 코드번호", example = "400")
        private Integer httpCodeNumber;

        @ApiModelProperty(value = "HTTP 코드 설명", example = "Bad Request")
        private String httpCodeTitle;
    }
}
