package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.FindAllResponseDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User fromRegisterRequestToUser(final UserRegisterRequestDto dto);
    List<FindAllResponseDto> fromUserListToResponseList(final List<User> userList);

    LoginResponseDto fromUserToLoginResponseDto(final User user);
}
