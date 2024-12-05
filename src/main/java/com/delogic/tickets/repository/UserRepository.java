package com.delogic.tickets.repository;

import com.delogic.tickets.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
