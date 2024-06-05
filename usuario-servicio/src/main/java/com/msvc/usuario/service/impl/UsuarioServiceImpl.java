package com.msvc.usuario.service.impl;

import com.msvc.usuario.entityes.Calificacion;
import com.msvc.usuario.entityes.Hotel;
import com.msvc.usuario.entityes.Usuario;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.external.services.CalificacionService;
import com.msvc.usuario.external.services.HotelService;
import com.msvc.usuario.repository.UsuarioRepository;
import com.msvc.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CalificacionService calificacionService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        String randomUsuarioId = UUID.randomUUID().toString();
        usuario.setUsuarioId(randomUsuarioId);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow( ()->new ResourceNotFoundException("Usuario no encontrado con el ID : " + usuarioId));

        Calificacion[] calificacionDelUsuario = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaciones/usuarios/"+usuario.getUsuarioId(), Calificacion[].class);
        logger.info("{}",calificacionDelUsuario);
        List<Calificacion> calificaciones = Arrays.stream(calificacionDelUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones = calificaciones.stream().map(calificacion -> {
           System.out.println(calificacion.getHotelId());
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hoteles/"+calificacion.getHotelId(), Hotel.class);Hotel hotel = forEntity.getBody();

            Hotel hotel = hotelService.getHotel(calificacion.getHotelId());
            //logger.info("Respuesta con codigo de estado : {}",forEntity.getStatusCode());

         calificacion.setHotel(hotel);
            return calificacion;

        }).collect(Collectors.toList());

        usuario.setCalificaciones(listaCalificaciones);

        return usuario;
    }

    @Override
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionService.guardarCalificacion(calificacion).getBody();
    }
    @Override
    public Calificacion actualizarCalificacion(String calificacionId, Calificacion calificacion) {
        return calificacionService.actualizarCalificacion(calificacionId, calificacion).getBody();
    }

    @Override
    public void eliminarCalificacion(String calificacionId) {
        calificacionService.eliminarCalificacion(calificacionId);
    }

    }

