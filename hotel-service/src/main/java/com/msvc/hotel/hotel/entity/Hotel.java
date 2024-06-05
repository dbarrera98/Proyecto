package com.msvc.hotel.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "informacion")
    private String informacion;

    @Column(name = "ubicacion")
    private String ubicacion;
}
