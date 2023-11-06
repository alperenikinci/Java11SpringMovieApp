package com.bilgeadam.dto.response;

import com.bilgeadam.repository.enums.EUserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {


    private String name;
    private String surname;
    private String email;
    private String phone;
    private EUserType userType;
    private List<Long> favMovie;
    private List<Long> favGenre;
    private List<Long> comments;

}
