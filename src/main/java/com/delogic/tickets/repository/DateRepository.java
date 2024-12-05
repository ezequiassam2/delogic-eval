package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {
}
