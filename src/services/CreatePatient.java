package services;

import entities.Patient;
import repositories.PatientRepository;

public class CreatePatient {
    private final PatientRepository patientRepository;

    public CreatePatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle(Patient patient) {
        this.patientRepository.create(patient);

        System.out.println("Paciente criado com sucesso.");
    }
}
