package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.create(calificacion));
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> listarCalificaciones(){
        return ResponseEntity.ok(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuarioId(@PathVariable String usuarioId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByUsuarioId(usuarioId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByHotelId(hotelId));
    }
}
