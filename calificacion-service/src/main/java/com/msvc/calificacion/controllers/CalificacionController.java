package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/{calificacionId}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable String calificacionId, @RequestBody Calificacion calificacion){
        calificacion.setCalificacionId(calificacionId);
        return ResponseEntity.ok(calificacionService.updateCalificacion(calificacion));
    }
   /* @DeleteMapping("/{calificacionId}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable String calificacionId){
        calificacionService.deleteCalificacion(calificacionId);
        return ResponseEntity.noContent().build();
    }*/

    @DeleteMapping("/{calificacionId}")
    public ResponseEntity<Map<String, String>> eliminarCalificacion(@PathVariable String calificacionId) {
        calificacionService.deleteCalificacion(calificacionId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Calificación eliminada correctamente");
        return ResponseEntity.ok(response);
    }


}


