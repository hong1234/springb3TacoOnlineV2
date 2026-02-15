package com.hong.flyway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import com.hong.flyway.domain.Taco;

public interface TacoRepository extends JpaRepository<Taco, Integer> {
    // @Modifying
    // @Query("delete from CartItemEntity c where c.id = :id")
    // void deleteById(UUID id); 
}