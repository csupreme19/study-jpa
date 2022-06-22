package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
