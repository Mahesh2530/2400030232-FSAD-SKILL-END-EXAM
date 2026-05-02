package com.klef.fsad.exam.service;

import com.klef.fsad.exam.entity.Hotel;
import com.klef.fsad.exam.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Create a new hotel (POST operation)
    public Hotel addHotel(Hotel hotel) {
        if (hotel.getHotelId() == null || hotel.getHotelId().isEmpty()) {
            throw new IllegalArgumentException("Hotel ID cannot be null or empty");
        }
        if (hotel.getName() == null || hotel.getName().isEmpty()) {
            throw new IllegalArgumentException("Hotel Name cannot be null or empty");
        }
        return hotelRepository.save(hotel);
    }

    // Update an existing hotel (PUT operation)
    public Hotel updateHotel(String hotelId, Hotel hotelDetails) {
        Optional<Hotel> existingHotel = hotelRepository.findById(hotelId);
        
        if (existingHotel.isPresent()) {
            Hotel hotel = existingHotel.get();
            
            if (hotelDetails.getName() != null) {
                hotel.setName(hotelDetails.getName());
            }
            if (hotelDetails.getDate() != null) {
                hotel.setDate(hotelDetails.getDate());
            }
            if (hotelDetails.getStatus() != null) {
                hotel.setStatus(hotelDetails.getStatus());
            }
            if (hotelDetails.getLocation() != null) {
                hotel.setLocation(hotelDetails.getLocation());
            }
            if (hotelDetails.getRating() != null) {
                hotel.setRating(hotelDetails.getRating());
            }
            if (hotelDetails.getContactNumber() != null) {
                hotel.setContactNumber(hotelDetails.getContactNumber());
            }
            
            return hotelRepository.save(hotel);
        } else {
            throw new RuntimeException("Hotel with ID " + hotelId + " not found");
        }
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by ID
    public Optional<Hotel> getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId);
    }

    // Delete a hotel
    public void deleteHotel(String hotelId) {
        if (hotelRepository.existsById(hotelId)) {
            hotelRepository.deleteById(hotelId);
        } else {
            throw new RuntimeException("Hotel with ID " + hotelId + " not found");
        }
    }

    // Check if hotel exists
    public boolean hotelExists(String hotelId) {
        return hotelRepository.existsById(hotelId);
    }
}
