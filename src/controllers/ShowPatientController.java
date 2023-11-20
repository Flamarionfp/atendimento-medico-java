package controllers;

import repositories.PatientRepository;
import services.ShowPatient;

import java.util.Scanner;

public class ShowPatientController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;

    public ShowPatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            System.out.println("Digite o nome do paciente: ");
            String name = scanner.nextLine();

            new ShowPatient(patientRepository).handle(name);
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
