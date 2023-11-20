package repositories;

import entities.Patient;

import java.util.ArrayList;
import java.util.UUID;

public class InMemoryPatientRepository implements PatientRepository {
    private final ArrayList<Patient> patients = new ArrayList<>();

    public void create(Patient patient) {
        this.patients.add(patient);
    }

    public Patient getById(UUID id) {
        return patients.stream().filter(patient -> patient.getId().equals(id)).findFirst().orElse(null);
    }

    public Patient getByName(String name) {
        return patients.stream().filter(patient -> patient.getName().equals(name)).findFirst().orElse(null);
    }

    public int getIndex(Patient patient) {
        return patients.indexOf(patient);
    }

    public void delete(Patient patient) {
        this.patients.remove(patient);
    }

    public void edit(int patientIndex, Patient patient)  {
        Patient patientToRemove = patients.get(patientIndex);
        patients.remove(patientToRemove);
        patients.add(patientIndex, patient);
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
}
