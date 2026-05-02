package com.klef.fsad.exam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
       
        return hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> getHotel(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        Optional<Hotel> existing = hotelRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Hotel with id " + id + " not found");
        }
        Hotel h = existing.get();
        
        h.setName(hotel.getName());
        h.setDate(hotel.getDate());
        h.setStatus(hotel.getStatus());
        h.setAddress(hotel.getAddress());
        h.setRating(hotel.getRating());
        return hotelRepository.save(h);
    }
}
