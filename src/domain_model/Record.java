package domain_model;

import domain_model.Discipline;
import domain_model.MemberCompetition;

import java.time.LocalDate;

public abstract class Record {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Discipline discipline;
    private int lengthMeter;
    private double resultTime;
    private LocalDate date;

    public Record(Discipline discipline, int lengthMeter, double resultTime, LocalDate date){
        this.discipline = discipline;
        this.lengthMeter = lengthMeter;
        this.resultTime = resultTime;
        this.date = date;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public Discipline getDiscipline() {
        return discipline;
    }

    public int getLengthMeter() {
        return lengthMeter;
    }

    public double getResultTime() {
        return resultTime;
    }

    public LocalDate getDate() {
        return date;
    }


    //------------------------------------------------------------------------------------------------------------------
}
