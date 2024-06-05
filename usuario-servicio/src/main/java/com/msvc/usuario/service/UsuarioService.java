package com.msvc.usuario.service;

import com.msvc.usuario.entityes.Calificacion;
import com.msvc.usuario.entityes.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuarios();

    Usuario getUsuario(String usuarioId);

    Calificacion guardarCalificacion(Calificacion calificacion);

    Calificacion actualizarCalificacion(String calificacionId, Calificacion calificacion);

    void eliminarCalificacion(String calificacionId);
}
