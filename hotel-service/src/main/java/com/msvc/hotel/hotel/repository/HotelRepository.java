package com.msvc.hotel.hotel.repository;

import com.msvc.hotel.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository <Hotel, String>{
}
