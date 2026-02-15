package com.hong.flyway.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import com.hong.flyway.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.uuid = :uuid")
    Optional<Cart> findByUuid(@Param("uuid") String uuid);   

    // @Query("SELECT c FROM CartEntity c JOIN c.customer u WHERE u.id = :customerId")
    // public Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}