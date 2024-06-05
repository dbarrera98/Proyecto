package com.msvc.usuario.external.services;

import com.msvc.usuario.entityes.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient (name = "CALIFICACION-SERVICE")
public interface CalificacionService {

    @PostMapping("/calificaciones")
    ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion);

    @PutMapping("/calificaciones/{calificacionId}")
    ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable("calificacionId") String calificacionId, @RequestBody Calificacion calificacion);

    @DeleteMapping("/calificaciones/{calificacionId}")
    void eliminarCalificacion(@PathVariable("calificacionId") String calificacionId);
}
