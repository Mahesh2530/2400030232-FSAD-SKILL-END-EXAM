package com.klef.fsad.exam.repository;

import com.klef.fsad.exam.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    // JpaRepository provides:
    // - save(Hotel) - for POST (CREATE)
    // - save(Hotel) - for PUT (UPDATE)
    // - findAll() - for GET all
    // - findById(String) - for GET by ID
    // - deleteById(String) - for DELETE
    // All basic CRUD operations are inherited
}
