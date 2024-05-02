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
    MemberCompetition memberCompetition;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(String discipline, int lengthMeter, double resultTime, String event,
                             LocalDate competitionDate, MemberCompetition memberCompetition){
        this.discipline = discipline;
        this.lengthMeter = lengthMeter;
        this.resultTime = resultTime;
        this.event = event;
        this.competitionDate = competitionDate;
        memberCompetition.addCompetitionRecord(this);

    }


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "Member's competition records\n"   +
                "Discipline: "  + discipline      + '\n'        +
                "Length: "      + lengthMeter     + "meter"     + '\n' +
                "Time result: " + df.format(resultTime) + '\n' +
                "Date: "        + competitionDate + '\n'        +
                "Event: "       + event           + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
