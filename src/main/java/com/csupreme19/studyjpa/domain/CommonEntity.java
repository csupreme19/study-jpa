package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass   // 공통 상위 엔티티를 정의
@EntityListeners(AuditingEntityListener.class)  // JPA Auditing 리스너
@ToString
public abstract class CommonEntity implements Serializable {
    @CreatedDate
    LocalDateTime createdAt;
    String createdIp;
    @LastModifiedDate
    LocalDateTime modifiedAt;
    String modifiedIp;
}
