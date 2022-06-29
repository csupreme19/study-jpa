package com.csupreme19.studyjpa.dto;

import com.csupreme19.studyjpa.domain.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto extends CommonDto {
    private String id;
    private String password;
    private String username;
    private Boolean enabled;
    private LocalDateTime lastPasswordModifiedAt;

    private Person person;
}
