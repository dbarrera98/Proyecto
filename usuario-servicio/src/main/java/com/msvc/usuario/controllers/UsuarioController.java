package com.msvc.usuario.controllers;

import com.msvc.usuario.entityes.Calificacion;
import com.msvc.usuario.entityes.Usuario;
import com.msvc.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuarioRequest) {
        Usuario usuario = usuarioService.saveUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String usuarioId) {
    Usuario usuario = usuarioService.getUsuario(usuarioId);
    return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @PostMapping("/calificaciones")
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion nuevaCalificacion = usuarioService.guardarCalificacion(calificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCalificacion);
    }

    @PutMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable String calificacionId, @RequestBody Calificacion calificacion) {
        Calificacion calificacionActualizada = usuarioService.actualizarCalificacion(calificacionId, calificacion);
        return ResponseEntity.ok(calificacionActualizada);
    }

    /*@DeleteMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable String calificacionId) {
        usuarioService.eliminarCalificacion(calificacionId);
        return ResponseEntity.noContent().build();
    }*/
    @DeleteMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Map<String, String>> eliminarCalificacion(@PathVariable String calificacionId) {
        usuarioService.eliminarCalificacion(calificacionId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Calificación eliminada correctamente");
        return ResponseEntity.ok(response);
    }
}
