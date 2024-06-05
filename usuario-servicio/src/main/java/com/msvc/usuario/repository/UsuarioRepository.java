package com.msvc.usuario.repository;

import com.msvc.usuario.entityes.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, String>{
}
