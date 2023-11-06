package com.bilgeadam.controller;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.FindAllResponseDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    "UserRepository" ve "UserService" katmanlarını yazalim.
    Bir register(kayit) islemi gerceklestirelim.
    kullanicidan alinmasi gereken veriler;
    name, surname, email, password
    Bu verileri DB'de bir kullanici olusturmak icin kullanalim.

    Bir request dto olusturalim. Ayni parametreler gecerli bir sekilde yeni bir metotta, parametreleri dto ile alalim.
    Metodumuzun ismi de : "register" olsun.

    register için bir mapper olusturalim.

    Kullanicilari ismine gore sirali getirin.
    //findAll() ile çek stream ile sırala
    //Jpa repository'nin metotlarini kullan. ->> Kazanan
    //Query atabiliriz.

    Login metodu yazalim. Disaridan "GEREKLİ" bilgileri alalim, bilgiler dogru ise bazi bilgileri eleyip, kullaniciya geri donelim.
    Bilgerden herhangi biri yanlis ise de RuntimeException firlatalim.

    Passwordunun uzunluğu belirediğimiz sayıdan buyuk olanlar (Query yazılacak)


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

//    @GetMapping("/findAllByOrderByName")
//    public ResponseEntity<List<User>> findAllByOrderByName(){
//        return ResponseEntity.ok(userService.findAllByOrderByName());
//    }

    @GetMapping("/findAllByOrderByNameResponse")
    public ResponseEntity<List<FindAllResponseDto>> findAllByOrderByNameResponse(){
        return ResponseEntity.ok(userService.findAllByOrderByNameResponse());
    }

    @PostMapping("/findAllByNameContainingIgnoreCase")
    public ResponseEntity<List<User>> findAllByNameContainingIgnoreCase(@RequestParam String value){
        return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(value));
    }

    @GetMapping("/findAllByEmailContainingIgnoreCase")
    public ResponseEntity<List<User>> findAllByEmailContainingIgnoreCase(String value){
        return ResponseEntity.ok(userService.findAllByEmailContainingIgnoreCase(value));
    }

    @GetMapping("/findAllByEmailEndingWith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }
    /*
        Login metodu yazalim. Disaridan "GEREKLİ" bilgileri alalim, bilgiler dogru ise bazi bilgileri eleyip, kullaniciya geri donelim.
    Bilgerden herhangi biri yanlis ise de RuntimeException firlatalim.
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }

//    @PostMapping("/login2")
//    public ResponseEntity<?> login2(@RequestBody LoginRequestDto dto){
//        try {
//            return ResponseEntity.ok(userService.login(dto));
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @GetMapping("/passwordLongerThan1")
    public ResponseEntity<List<User>> passwordLongerThan1(int value){
        return ResponseEntity.ok(userService.passwordLongerThan1(value));
    }

    @GetMapping("/passwordLongerThan2")
    public ResponseEntity<List<User>> passwordLongerThan2(int value){
        return ResponseEntity.ok(userService.passwordLongerThan2(value));
    }
    @GetMapping("/passwordLongerThan3")
    public ResponseEntity<List<User>> passwordLongerThan3(int value){
        return ResponseEntity.ok(userService.passwordLongerThan3(value));
    }



}
