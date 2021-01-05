package com.desenv.personapi.mapper;

import com.desenv.personapi.entity.Usuario;
import com.desenv.personapi.dto.request.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author vinicius
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

//    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Usuario toModel(UsuarioDTO usuarioDTO);

	UsuarioDTO toDTO(Usuario usuario);
}
