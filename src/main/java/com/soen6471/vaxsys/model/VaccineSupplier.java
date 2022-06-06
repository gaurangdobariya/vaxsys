package com.soen6471.vaxsys.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`vaccineSupplier`")
public class VaccineSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "Name")
    private String name;

    @Column(name = "VaccineID")
    private Integer vaccineID;

    @Column(name = "Location")
    private String location;
}
