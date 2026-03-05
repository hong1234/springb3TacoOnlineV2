package com.hong.flyway.repository;
import org.springframework.data.jpa.repository.JpaRepository; 
import com.hong.flyway.domain.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Integer> { 
	UserAccount findByUsername(String username);
}