package com.klef.fsad.exam;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    private final HotelRepository hotelRepository;

    public HotelController(HotelService hotelService, HotelRepository hotelRepository) {
        this.hotelService = hotelService;
        this.hotelRepository = hotelRepository;
    }

    // Add Hotel - POST
    @PostMapping
    public ResponseEntity<?> addHotel(@Valid @RequestBody Hotel hotel) {
        if (hotel.getId() == null) {
            return ResponseEntity.badRequest().body("Hotel ID must be provided and not null");
        }
        if (hotelRepository.existsById(hotel.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Hotel with ID already exists");
        }
        Hotel saved = hotelService.addHotel(hotel);
        return ResponseEntity.created(URI.create("/api/hotels/" + saved.getId())).body(saved);
    }

    // Update Hotel - PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @Valid @RequestBody Hotel hotel) {
        try {
            // if body id is null, set it to path id to be safe
            if (hotel.getId() == null) {
                hotel.setId(id);
            }
            if (!id.equals(hotel.getId())) {
                return ResponseEntity.badRequest().body("Path id and body id must match");
            }
            Hotel updated = hotelService.updateHotel(id, hotel);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
