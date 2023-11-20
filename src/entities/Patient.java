package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Patient {
    private final UUID id;
    private String name;
    private LocalDate birthDate;
    private final ArrayList<MedicalAttention> medicalAttentions = new ArrayList<>();
    public Patient(String name, LocalDate birthDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public ArrayList<MedicalAttention> getMedicalAttentions() {
        return medicalAttentions;
    }

    public void addMedicalAttention(MedicalAttention medicalAttention) {
        this.medicalAttentions.add(medicalAttention);
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(getBirthDate(), currentDate);

        return period.getYears();
    }

    @Override
    public String toString() {
        String formattedId = "ID: " + id.toString();
        String formattedName = " Nome completo: " + name;
        DateTimeFormatter dateInBrFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = dateInBrFormat.format(this.birthDate);

        return formattedId + formattedName + " Data de nascimento: " + formattedDate + " Idade: " + getAge();
    }
}
