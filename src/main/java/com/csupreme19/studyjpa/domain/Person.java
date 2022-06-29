package com.csupreme19.studyjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Entity
@ToString(exclude = "account")
public class Person extends CommonEntity {
    @Id
    private Long id;

    private Long age;
    private String phone;
    private String email;

    @OneToOne   // OneToOne 매핑은 엔티티 1:1 매핑으로 기본값으로 Eager의 FetchType
    @JsonBackReference  // 양방향 매핑에서 JSON Serialize를 제외
    @JoinColumn(name = "account_id")    // 현재 테이블에서 해당 컬럼명을 기준으로 조인
    private Account account;
}