package controllers;

import repositories.PatientRepository;

import services.ListPatients;

public class ListPatientsController {
    private final PatientRepository patientRepository;

    public ListPatientsController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            new ListPatients(patientRepository).handle();
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
