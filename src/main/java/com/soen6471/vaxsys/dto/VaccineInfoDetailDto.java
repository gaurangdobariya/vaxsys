package com.soen6471.vaxsys.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VaccineInfoDetailDto {

    private String DiseaseName;
    private String VaccineName;
    private Integer NoOfDoses;
    private String Location;

}
