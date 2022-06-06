package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;
/**
 * This is model classs for admin.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`admin`")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name ="Email")
    private String email;

    @Column(name = "Password")
    private String password;

}
