package com.hong.flyway.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import com.hong.flyway.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.uuid = :uuid")
    Optional<Order> findByUuid(@Param("uuid") String uuid); 

    // @Modifying
    // @Query("delete from CartItemEntity c where c.id = :id")
    // void deleteById(UUID id); 
}