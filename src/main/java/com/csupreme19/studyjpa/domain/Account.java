package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@Setter
public class Account {
    @Id
    private String id;
    private String password;
    private String username;
    private Boolean enabled;
    private LocalDateTime lastPasswordModifiedAt;
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}