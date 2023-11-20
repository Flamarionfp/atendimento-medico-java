package services;

import entities.Patient;
import repositories.PatientRepository;

import java.util.ArrayList;

public class ListPatients {
    private final PatientRepository patientRepository;

    public ListPatients(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() throws Exception {
        ArrayList<Patient> patients = patientRepository.getPatients();

        if (patients.isEmpty()) throw new Exception("Nenhum paciente encontrado");

        System.out.println("Pacientes: ");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}
