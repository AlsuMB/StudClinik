package ru.kpfu.sem1.studclinic.models.exception;

public class NoneOfDoctorException extends Exception {
    public NoneOfDoctorException() {
        super("This isn't doctor");
    }
}
