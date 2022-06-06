package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;
/**
 * This is model classs for disease.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`disease`")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "Name")
    private String name ;

    @Column(name = "Symptoms")
    private String symptoms;
}
