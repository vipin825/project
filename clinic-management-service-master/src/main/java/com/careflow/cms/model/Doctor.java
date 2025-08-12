package com.careflow.cms.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Doctor extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(length = 255)
    private String specialty;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 100)
    private String email;



    // A doctor can have multiple patients, but a patient is associated with one doctor (can be null)
    // This side is the "owning" side for adding patients in some scenarios, but not strictly required by the FK constraint
    // The "max 4 patients" rule needs to be handled in the service layer or via database triggers.
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true) //
    private List<Patient> patients;

    // Relationship with Appointments
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Appointment> appointments;
}
