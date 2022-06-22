package com.csupreme19.studyjpa.config;

import com.csupreme19.studyjpa.exception.CustomNoSuchDataException;
import com.csupreme19.studyjpa.model.CommonResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller 공통 예외 처리 핸들러
 * @author csupreme19
 * @since 2022.06.22
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({CustomNoSuchDataException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse noContent() {
        HttpStatus httpStatus = HttpStatus.NO_CONTENT;
        return CommonResponse.builder()
                .code(httpStatus.value())
                .message(httpStatus.name())
                .build();
    }

}