package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
