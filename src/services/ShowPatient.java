package services;

import entities.MedicalAttention;
import entities.Patient;
import repositories.PatientRepository;

import java.util.List;

public class ShowPatient {
    private final PatientRepository patientRepository;

    public ShowPatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle(String name) throws Exception {
        Patient patient = patientRepository.getByName(name);

        if (patient == null) throw new Exception("Paciente não encontrado.");

        int showLastNAttentions = 5;
        List<MedicalAttention> latestMedicalAttentions = patient.getLatestMedicalAttentions(showLastNAttentions);

        System.out.println("Paciente: " + patient);

        System.out.println("Últimas " + showLastNAttentions + " consultas: ");
        for (MedicalAttention medicalAttention : latestMedicalAttentions) {
            System.out.println(medicalAttention);
        }
    }
}
