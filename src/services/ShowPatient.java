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

        System.out.println("Todas as consultas: ");

        List<MedicalAttention> medicalAttentions = patient.getMedicalAttentions();
        int dividerIn = 5;

        for (int i = 0; i < medicalAttentions.size(); i += dividerIn) {
            System.out.println("-------------------");
            int end = Math.min(i + dividerIn, medicalAttentions.size());
            List<MedicalAttention> batch = medicalAttentions.subList(i, end);

            for (MedicalAttention medicalAttention : batch) {
                System.out.println(medicalAttention);
            }

            System.out.println("-------------------");
        }
    }
}
