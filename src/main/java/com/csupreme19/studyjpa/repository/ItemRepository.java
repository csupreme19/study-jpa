package com.csupreme19.studyjpa.repository;

import com.csupreme19.studyjpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
