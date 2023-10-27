package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
    "UserRepository" ve "UserService" katmanlarını yazalim.
    Bir register(kayit) islemi gerceklestirelim.
    kullanicidan alinmasi gereken veriler;
    name, surname, email, password
    Bu verileri DB'de bir kullanici olusturmak icin kullanalim.

    Bir request dto olusturalim. Ayni parametreler gecerli bir sekilde yeni bir metotta, parametreleri dto ile alalim.
    Metodumuzun ismi de : "register" olsun.

    register için bir mapper olusturalim.

 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
   //  @RequestParam(required = true, defaultValue = "1829347619238756", name = "sifre") String password)
    @GetMapping("/save")
    public ResponseEntity<User> createUser(String name, String surname, String email, @RequestParam() String password){
        return ResponseEntity.ok(userService.createUser(name,surname,email,password));
    }

    @GetMapping("/register")
    public ResponseEntity<User> register(UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.register2(dto));
    }

    @PostMapping("/register2")
    public ResponseEntity<User> register2(@RequestBody UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.register2(dto));
    }


}
