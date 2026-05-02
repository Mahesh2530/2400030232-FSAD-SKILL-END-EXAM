package com.klef.fsad.exam;

import java.util.Optional;

public interface HotelService {
    Hotel addHotel(Hotel hotel);
    Optional<Hotel> getHotel(Long id);
    Hotel updateHotel(Long id, Hotel hotel);
}
