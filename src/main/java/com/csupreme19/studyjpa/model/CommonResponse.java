package com.csupreme19.studyjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResponse() {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
        this.data = null;
    }

    public CommonResponse(T data) {
        this();
        this.data = data;
    }
}
