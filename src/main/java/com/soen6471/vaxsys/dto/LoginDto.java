package com.soen6471.vaxsys.dto;

import lombok.*;

import javax.persistence.Entity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {
    private String emailId;
    private String password;

}
