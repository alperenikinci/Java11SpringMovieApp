package com.bilgeadam.service;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.FindAllResponseDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IServiceCrud<User>{
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

//    public List<User> findAllByOrderByName(){
//        return userRepository.findAllByOrderByName();
//    }

    public List<FindAllResponseDto> findAllByOrderByNameResponse(){
        return IUserMapper.INSTANCE.fromUserListToResponseList(userRepository
                .findAllByOrderByName());
    }

    public List<User> findAllByNameContainingIgnoreCase(String value){
        return userRepository.findAllByNameContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailContainingIgnoreCase(String value) {
        return userRepository.findAllByEmailContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailEndingWith(String value){
        return userRepository.findAllByEmailEndingWith(value);
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> user = userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isPresent()) {
            return IUserMapper.INSTANCE.fromUserToLoginResponseDto(user.get());
        }else{
            throw new RuntimeException("Boyle bir kullanici bulunmamaktadir...");
        }
    }

    public List<User> passwordLongerThan1(int value){
        return userRepository.passwordLongerThan1(value);
    }

    public List<User> passwordLongerThan2(int value){
        return userRepository.passwordLongerThan2(value);
    }

    public List<User> passwordLongerThan3(int value){
        return userRepository.passwordLongerThan3(value);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return userRepository.saveAll(t);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
