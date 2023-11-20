package controllers;

import repositories.PatientRepository;
import services.EditPatient;
import utils.Date;

import java.time.LocalDate;
import java.util.Scanner;

public class EditPatientController {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;

    public EditPatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void handle() {
        try {
            System.out.println("Digite o nome do paciente que deseja editar: ");
            String name = scanner.nextLine();

            char response;

            System.out.println("Deseja alterar o nome? (s / n) ");
            response = scanner.nextLine().charAt(0);

            String newName = null;
            LocalDate newBirthdate = null;

            if (response == 's') {
                System.out.println("Digite o novo nome: ");
                newName = scanner.nextLine();
            }

            System.out.println("Deseja alterar a data de nascimento? (s / n)");
            response = scanner.nextLine().charAt(0);

            if (response == 's') {
                System.out.println("Digite a nova data de nascimento: ");
                String splitNewBirthdate = scanner.nextLine();

                newBirthdate = Date.fromPtBrString(splitNewBirthdate);
            }

            new EditPatient(patientRepository).handle(name, newName, newBirthdate);
        } catch (Exception error) {
            System.out.println("Ocorreu um problema: " + error.getMessage());
        }
    }
}
