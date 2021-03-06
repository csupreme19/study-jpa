package com.csupreme19.studyjpa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@Access(AccessType.FIELD)
@ToString(exclude = "account")
public class Person extends CommonEntity {
    @Id
    private Long id;

    private Long age;
    private String phone;

    @Transient              // 영속성 대상에서 제외한다.
    private String email;

    @Transient              // 필드 접근자 방식이므로 해당 Transient는 적용되지 않음
    public String getPhone(){
        return this.phone;
    }

    @OneToOne(fetch = FetchType.EAGER)   // OneToOne 매핑은 엔티티 1:1 매핑으로 기본값으로 Eager의 FetchType
    @JsonBackReference  // 양방향 매핑에서 JSON Serialize를 제외
    @JoinColumn(name = "accountId")    // 현재 테이블에서 해당 컬럼명을 기준으로 조인
    private Account account;
}