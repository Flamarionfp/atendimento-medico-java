package services;

import entities.MedicalAttention;
import entities.Patient;
import repositories.PatientRepository;
public class AddMedicalAttention {

    private final PatientRepository patientRepository;

    public AddMedicalAttention(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle(String patientName, MedicalAttention medicalAttention) throws Exception {
        Patient patient = patientRepository.getByName(patientName);

        if (patient == null) throw new Exception("Paciente não encontrado.");

        patient.addMedicalAttention(medicalAttention);

        System.out.println("Consulta adicionada com sucesso.");
    }
}

