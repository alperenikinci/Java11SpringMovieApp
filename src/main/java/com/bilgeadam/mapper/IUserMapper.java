package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User fromRegisterRequestToUser(final UserRegisterRequestDto dto);

  //  RegisterResponseDto fromUserToRegisterResponse(User user)

}
