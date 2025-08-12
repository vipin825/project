package com.careflow.cms.exception;

public class DoctorNotFoundException extends RuntimeException{
    private Long id;
    public DoctorNotFoundException(final Long id) {
        super("Cannot find Doctor with Id : " + id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
