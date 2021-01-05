package com.desenv.personapi.service;

import com.desenv.personapi.entity.Usuario;
import com.desenv.personapi.dto.request.UsuarioDTO;
import com.desenv.personapi.dto.response.MessageResponseDTO;
import com.desenv.personapi.exception.PersonNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desenv.personapi.repository.UsuarioRepository;
import com.desenv.personapi.mapper.UsuarioMapper;

/**
 *
 * @author vinicius
 */
@Service
@AllArgsConstructor(onConstructor = @__(
		@Autowired))
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioMapper usuarioMapper;

	public MessageResponseDTO create(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioMapper.toModel(usuarioDTO);
		Usuario savedUsuario = usuarioRepository.save(usuario);

		MessageResponseDTO messageResponse = createMessageResponse("User successfully created with ID ", savedUsuario.getId());

		return messageResponse;
	}

public MessageResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws PersonNotFoundException {
        usuarioRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        Usuario updatedUsuario = usuarioMapper.toModel(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(updatedUsuario);

        MessageResponseDTO messageResponse = createMessageResponse("User successfully updated with ID ", savedUsuario.getId());

        return messageResponse;
    }

	public UsuarioDTO findById(Long id) throws PersonNotFoundException {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));

		return usuarioMapper.toDTO(usuario);
	}

	public List<UsuarioDTO> listAll() {
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario.stream()
				.map(usuarioMapper::toDTO)
				.collect(Collectors.toList());
	}

 private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}
