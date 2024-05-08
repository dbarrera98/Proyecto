package com.msvc.hotel.hotel.service.impl;

import com.msvc.hotel.hotel.entity.Hotel;
import com.msvc.hotel.hotel.exceptions.ResourceNotFoundException;
import com.msvc.hotel.hotel.repository.HotelRepository;
import com.msvc.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con el ID : " + id));
    }
}
