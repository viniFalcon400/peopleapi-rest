package com.desenv.personapi.controller;

import com.desenv.personapi.service.UsuarioService;
import com.desenv.personapi.dto.request.UsuarioDTO;
import com.desenv.personapi.dto.response.MessageResponseDTO;
import com.desenv.personapi.exception.PersonNotFoundException;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vinicius
 */
@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor(onConstructor = @__(
		@Autowired))
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		return usuarioService.create(usuarioDTO);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO) throws PersonNotFoundException {
		return usuarioService.update(id, usuarioDTO);
	}

	@GetMapping
	public List<UsuarioDTO> listAll() {
		return usuarioService.listAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return usuarioService.findById(id);
	}
}
