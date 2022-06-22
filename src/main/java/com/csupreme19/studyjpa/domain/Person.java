package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Person {
    @Id
    private Long id;
    private String accountId;
    private Long age;
    private String phone;
    private String email;
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}