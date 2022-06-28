package com.csupreme19.studyjpa.dto;

import java.time.LocalDateTime;

public abstract class CommonDto {
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}
