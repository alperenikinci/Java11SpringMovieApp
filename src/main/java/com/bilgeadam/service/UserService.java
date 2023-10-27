package com.bilgeadam.service;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository; //instantiate ->> instance

    public User createUser(String name, String surname, String email, String password) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
        return userRepository.save(user);
    }

    public User register(UserRegisterRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public User register2(UserRegisterRequestDto dto) {
        User user = IUserMapper.INSTANCE.fromRegisterRequestToUser(dto);
      return userRepository.save(user);
    }

}
