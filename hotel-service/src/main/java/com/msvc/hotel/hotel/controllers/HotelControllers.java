package com.msvc.hotel.hotel.controllers;

import com.msvc.hotel.hotel.entity.Hotel;
import com.msvc.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")

public class HotelControllers {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> guardarHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> obtenerHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));

    }

    @GetMapping
    public ResponseEntity<List<Hotel>> listarHoteles() {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getAll());
    }
}
