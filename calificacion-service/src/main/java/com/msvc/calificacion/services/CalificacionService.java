package com.msvc.calificacion.services;

import com.msvc.calificacion.entity.Calificacion;

import java.util.List;

public interface CalificacionService {

    Calificacion create(Calificacion calificacion);

    List<Calificacion> getCalificaciones();

    List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionesByHotelId(String hotelId);

}
