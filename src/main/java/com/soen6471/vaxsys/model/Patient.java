package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * This is model classs for AAA.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`patient`")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "PhoneNo")
    private String phoneNo;

    @Column(name = "DOB")
    private Date dOB;

    @Column(name = "EmailID")
    private String emailID;

    @Column(name = "Address")
    private  String address;

    @Column(name = "Password")
    private String password;
}
