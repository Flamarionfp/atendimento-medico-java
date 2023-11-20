package controllers;

import entities.MedicalAttention;
import repositories.PatientRepository;
import services.AddMedicalAttention;
import utils.Date;

import java.time.LocalDate;
import java.util.Scanner;

public class AddMedicalAttentionController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;

    public AddMedicalAttentionController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            System.out.println("Digite o nome do paciente: ");
            String name = scanner.nextLine();

            System.out.println("Digite a data da consulta (dd/mm): ");
            String date = scanner.nextLine();

            System.out.println("Descrição da consulta: ");
            String description = scanner.nextLine();

            MedicalAttention medicalAttention = new MedicalAttention(Date.fromPtBrString(date), description);

            new AddMedicalAttention(patientRepository).handle(name, medicalAttention);
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
