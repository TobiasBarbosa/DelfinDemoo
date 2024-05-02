package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class CompetitionRecord {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String discipline;
    private int lengthMeter;
    private double resultTime;
    private String event;
    private LocalDate competitionDate;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(String discipline, int lengthMeter, double resultTime, String event,
                             LocalDate competitionDate){
        this.discipline = discipline;
        this.lengthMeter = lengthMeter;
        this.resultTime = resultTime;
        this.event = event;
        this.competitionDate = competitionDate;

    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "domain_model.Member's competition records\n"   +
                "domain_model.Discipline: "  + discipline      + '\n'        +
                "Length: "      + lengthMeter     + "meter"     + '\n' +
                "Time result: " + df.format(resultTime) + '\n' +
                "Date: "        + competitionDate + '\n'        +
                "domain_model.Discipline: "  + event           + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
