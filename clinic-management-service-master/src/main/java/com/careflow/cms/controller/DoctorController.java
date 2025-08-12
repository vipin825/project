package com.careflow.cms.controller;

import com.careflow.cms.dto.DoctorDTO;
import com.careflow.cms.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/cms/v1/doctors")
@Tag(name = "DoctorController", description = "Doctor API for CRUD Operation")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Operation(summary = "Create a New Doctor")
    public ResponseEntity create(@RequestBody DoctorDTO doctorDTO) {
        return new ResponseEntity<>(doctorService.create(doctorDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Display a List of Doctors")
    public ResponseEntity<List<DoctorDTO>> getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @PostMapping("/{id}")
    @Operation(summary = "Update an Existing Doctor")
    public ResponseEntity<DoctorDTO> update(@PathVariable Long id,@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.update(id, doctorDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an Existing Doctor")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

   @GetMapping("/{id}")
   @Operation(summary = "Find an Existing Doctor")
    public ResponseEntity<DoctorDTO> getById(@PathVariable Long id) {
       return ResponseEntity.ok(doctorService.getById(id)) ;
    }
}
