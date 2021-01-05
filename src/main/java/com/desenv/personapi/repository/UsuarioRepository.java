package com.desenv.personapi.repository;

import com.desenv.personapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vinicius
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
