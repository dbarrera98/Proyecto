package com.msvc.calificacion.repository;

import com.msvc.calificacion.entity.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalificacionRepository extends MongoRepository<Calificacion,String> {

    List<Calificacion> findByUsuarioId(String usuarioId);
    List<Calificacion> findByHotelId(String hotelId);
}