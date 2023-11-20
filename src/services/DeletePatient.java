package services;

import entities.Patient;
import repositories.PatientRepository;

import java.util.UUID;

public class DeletePatient {
    private final PatientRepository patientRepository;

    public DeletePatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle(UUID id) throws Exception {
        Patient patientToDelete = patientRepository.getById(id);

        if (patientToDelete == null) throw new Exception("Paciente não encontrado.");

        this.patientRepository.delete(patientToDelete);

        System.out.println("Paciente excluido com sucesso.");
    }
}
