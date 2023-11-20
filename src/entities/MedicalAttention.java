package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicalAttention {
    private LocalDate date;

    private String description;

    public MedicalAttention(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        DateTimeFormatter dateInBrFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateInBrFormat.format(this.date);

        return " Data: "+ formattedDate + "\nInformações: "+ description;
    }
}
