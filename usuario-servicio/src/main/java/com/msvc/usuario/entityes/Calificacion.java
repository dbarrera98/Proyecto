package com.msvc.usuario.entityes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    private  String calificacionId;

    private  String usuarioId;

    private  String hotelId;

    private int calificacion;

    private String observaciones;

    private Hotel hotel;

}
