package repositories;

import entities.Patient;

import java.util.ArrayList;
import java.util.UUID;

public interface PatientRepository {
    public ArrayList<Patient> getPatients();
    public Patient getById(UUID id);
    public Patient getByName(String name);
    public int getIndex(Patient patient);
    public void create(Patient patient);
    public void delete(Patient patient);
    public void edit(int patientIndex, Patient patient);
}
