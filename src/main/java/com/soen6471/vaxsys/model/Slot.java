package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;

/**
 * This is model classs for slot.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode()
@Table(name = "`slot`")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "Time")
    private String time;
}
