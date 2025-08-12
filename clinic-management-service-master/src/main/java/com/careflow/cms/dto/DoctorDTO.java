package com.careflow.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Lombok annotation for a no-argument constructor
@AllArgsConstructor
public class DoctorDTO {

    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private String phoneNumber;
    private String email;

}
