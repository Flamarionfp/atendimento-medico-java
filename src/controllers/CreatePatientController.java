package controllers;

import entities.Patient;
import repositories.PatientRepository;
import services.CreatePatient;
import utils.Date;

import java.util.Scanner;

public class CreatePatientController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;

    public CreatePatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            System.out.println("Digite os dados do paciente: ");
            System.out.println("Nome: ");
            String name = scanner.nextLine();
            System.out.println("Data de nascimento: (dd/mm/aaaa)");
            String birthDate = scanner.nextLine();
            Patient patient = new Patient(name, Date.fromPtBrString(birthDate));
            new CreatePatient(patientRepository).handle(patient);
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
