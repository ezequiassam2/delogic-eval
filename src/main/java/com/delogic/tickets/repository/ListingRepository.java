package com.delogic.tickets.repository;

import com.delogic.tickets.domain.Listing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ListingRepository extends BaseRepository<Listing, Long> {

    @Query("SELECT l.id FROM Listing l " +
            "JOIN l.event e " +
            "JOIN e.venue v " +
            "LEFT JOIN Sale s ON s.listing.id = l.id " +
            "WHERE s.id IS NULL " +
            "AND e.startTime <= :contextDate " +
            "AND (:categoryId IS NULL OR e.category.id = :categoryId) " +
            "AND (:city IS NULL OR v.city = :city) " +
            "ORDER BY e.startTime DESC LIMIT 10")
    List<Long> findUnsoldListings(@Param("contextDate") LocalDateTime contextDate,
                                  @Param("categoryId") Long categoryId,
                                  @Param("city") String city);
}