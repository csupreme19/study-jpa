package com.csupreme19.studyjpa.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Account extends CommonEntity {
    @Id
    private String id;
    private String password;
    private String username;
    private Boolean enabled;
    private LocalDateTime lastPasswordModifiedAt;

    public void updateAccount(String username, Boolean enabled) {
        this.username = username;
        this.enabled = enabled;
    }

    public void updatePassword(String password) {
        this.password = password;
        this.lastPasswordModifiedAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
}