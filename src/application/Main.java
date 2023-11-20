package application;

import controllers.*;
import repositories.InMemoryPatientRepository;
import repositories.PatientRepository;

public class Main {
    public static void main (String[] args) {
        PatientRepository patientRepository = new InMemoryPatientRepository();
        int selectedOption;

        System.out.println("Gerenciamento de consultas médicas");

        do {
            Menu.show();
            selectedOption = Menu.getSelectedOption();

            switch (selectedOption) {
                case 1: {
                    new CreatePatientController(patientRepository).handle();
                    break;
                }
                case 2: {
                    new EditPatientController(patientRepository).handle();
                    break;
                }
                case 3: {
                    new AddMedicalAttentionController(patientRepository).handle();
                    break;
                }
                case 4: {
                    new ListPatientsController(patientRepository).handle();
                    break;
                } case 5: {
                    new ShowPatientController(patientRepository).handle();
                    break;
                } case 6: {
                    new DeletePatientController(patientRepository).handle();
                    break;
                }
            }
        } while (selectedOption != Menu.LAST_OPTION);
    }
}
