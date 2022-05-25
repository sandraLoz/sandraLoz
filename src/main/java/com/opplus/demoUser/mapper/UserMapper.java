package com.opplus.demoUser.mapper;

import org.mapstruct.Mapper;
import com.opplus.demoUser.domain.UserEntity;
import com.opplus.demoUser.dto.UserDto;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDto, UserEntity>{


}
