package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Entity
@ToString
public class Account extends CommonEntity {
    @Id
    private String id;
    private String password;
    private String username;
    private Boolean enabled;
    private LocalDateTime lastPasswordModifiedAt;

    @OneToOne(mappedBy = "account")     // 양방향 매핑 관계를 정의
    private Person person;

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