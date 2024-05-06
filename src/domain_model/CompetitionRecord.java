package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class CompetitionRecord {

    //QUESTIONS & MISSING CODE***---------------------------------------------------------------------------------------
    //How to insert the member in the constructor so it connects to an actual instance?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Discipline discipline;
    private int lengthMeter;
    private double resultTimeMinutes;
    private String event;
    private LocalDate competitionDate;
    MemberCompetition memberCompetition;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(Discipline discipline, int lengthMeter, double resultTimeMinutes, String event,
                             LocalDate competitionDate /*, MemberCompetition memberCompetition*/){
        this.discipline = discipline;
        this.lengthMeter = lengthMeter;
        this.resultTimeMinutes = resultTimeMinutes;
        this.event = event;
        this.competitionDate = competitionDate;
        //this.memberCompetition = memberCompetition;
        //memberCompetition.addCompetitionRecord(this);

    }


    //***METHODS***-----------------------------------------------------------------------------------------------------


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return /*"***MEMBER'S COMPETITION RECORDS***\n"*/ "\n"  +
                "Discipline: "        + discipline      + '\n'        +
                "Length: "            + lengthMeter     + " meter"    + '\n' +
                "Time result (min): " + df.format(resultTimeMinutes) + '\n' +
                "Date: "              + competitionDate + '\n'        +
                "Event: "             + event           + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
