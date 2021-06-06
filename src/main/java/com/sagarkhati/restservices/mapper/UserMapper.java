package com.sagarkhati.restservices.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sagarkhati.restservices.dto.UserMsDto;
import com.sagarkhati.restservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	// User to UserDTO Object
	@Mappings({ @Mapping(source = "email", target = "emailaddress"), @Mapping(source = "role", target = "rolename") })
	UserMsDto userToUserMsDto(User user);

	// List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserDto(List<User> users);
}
