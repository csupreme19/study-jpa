package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Account extends CommonEntity {
    @Id
    private String id;
    private String password;
    private String username;
    private Boolean enabled;
    private LocalDateTime lastPasswordModifiedAt;
}