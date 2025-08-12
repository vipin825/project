package com.careflow.cms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointment", uniqueConstraints = {
       @UniqueConstraint(name = "uc_patient_day", columnNames = {"patient_id", "appointment_date"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @ManyToOne(fetch = FetchType.LAZY) // Many appointments can be for one patient
    @JoinColumn(name = "patient_id", nullable = false, foreignKey = @ForeignKey(name = "appointment_patient_fk"))
    private Patient patient;

    @NotNull(message = "Doctor cannot be null")
    @ManyToOne(fetch = FetchType.LAZY) // Many appointments can be with one doctor
    @JoinColumn(name = "doctor_id", nullable = false, foreignKey = @ForeignKey(name = "appointment_doctor_fk"))
    private Doctor doctor;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_status", nullable = false, length = 20)
    private String appointmentStatus; // e.g., SCHEDULED, COMPLETED, CANCELLED

}
