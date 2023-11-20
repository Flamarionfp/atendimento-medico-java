package services;

import entities.Patient;
import repositories.PatientRepository;

import java.time.LocalDate;

public class EditPatient {
    private final PatientRepository patientRepository;

    public EditPatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle(String name, String newName, LocalDate newBirthDate) throws Exception {
        Patient patient = patientRepository.getByName(name);
        int patientIndex = patientRepository.getIndex(patient);

        if (patientIndex == -1) throw new Exception("Paciente não encontrado.");

        if (newName != null) patient.setName(newName);
        if (newBirthDate != null) patient.setBirthDate(newBirthDate);

        patientRepository.edit(patientIndex, patient);

        System.out.println("Paciente editado com sucesso.");
    }
}
