package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person extends CommonEntity {
    @Id
    private Long id;
    private String accountId;
    private Long age;
    private String phone;
    private String email;
}