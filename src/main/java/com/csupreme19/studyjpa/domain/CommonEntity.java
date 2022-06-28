package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class CommonEntity {
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}
