package controllers;

import repositories.PatientRepository;
import services.DeletePatient;
import java.util.Scanner;
import java.util.UUID;

public class DeletePatientController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;

    public DeletePatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            System.out.println("Digite o ID do paciente que deseja excluir: ");
            UUID id = UUID.fromString(scanner.nextLine());

            new DeletePatient(patientRepository).handle(id);
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
