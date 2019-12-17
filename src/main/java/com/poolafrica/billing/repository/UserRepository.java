package com.poolafrica.billing.repository;

import com.poolafrica.billing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
