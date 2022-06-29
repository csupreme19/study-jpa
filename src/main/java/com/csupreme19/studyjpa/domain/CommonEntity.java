package com.csupreme19.studyjpa.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 공통 상위 엔티티를 정의
public abstract class CommonEntity implements Serializable {
    LocalDateTime createdAt;
    String createdIp;
    LocalDateTime modifiedAt;
    String modifiedIp;
}
