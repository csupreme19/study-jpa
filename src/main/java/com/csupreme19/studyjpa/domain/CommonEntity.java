package com.csupreme19.studyjpa.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class CommonEntity {
    LocalDateTime createdAt;
    String createdIp;
    LocalDateTime modifiedAt;
    String modifiedIp;
}
