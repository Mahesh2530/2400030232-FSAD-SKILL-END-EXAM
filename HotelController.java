package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.entity.Hotel;
import com.klef.fsad.exam.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend access
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // POST - Add a new hotel
    @PostMapping
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel) {
        try {
            if (hotel.getHotelId() == null || hotel.getHotelId().isEmpty()) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Hotel ID is required and cannot be null");
            }
            
            Hotel savedHotel = hotelService.addHotel(hotel);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedHotel);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Error: " + e.getMessage());
        }
    }

    // PUT - Update an existing hotel
    @PutMapping("/{hotelId}")
    public ResponseEntity<?> updateHotel(
            @PathVariable String hotelId,
            @RequestBody Hotel hotelDetails) {
        try {
            Hotel updatedHotel = hotelService.updateHotel(hotelId, hotelDetails);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedHotel);
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Error: " + e.getMessage());
        }
    }

    // GET - Get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // GET - Get hotel by ID
    @GetMapping("/{hotelId}")
    public ResponseEntity<?> getHotelById(@PathVariable String hotelId) {
        Optional<Hotel> hotel = hotelService.getHotelById(hotelId);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error: Hotel with ID " + hotelId + " not found");
        }
    }

    // DELETE - Delete a hotel
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable String hotelId) {
        try {
            hotelService.deleteHotel(hotelId);
            return ResponseEntity.ok("Hotel with ID " + hotelId + " deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error: " + e.getMessage());
        }
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("Hotel Management API is running");
    }
}
