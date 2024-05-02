package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class TrainingRecord {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Should we put a domain_model.Member object inside the constructor?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String discipline;
    private int lengthMeter;
    private double resultTime;
    private LocalDate trainingDate;
    private MemberCompetition memberCompetition;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public TrainingRecord(String discipline, int lengthMeter, double resultTime, String event,
                          LocalDate competitionDate, MemberCompetition memberCompetition){
        this.discipline = discipline.toString();
        this.lengthMeter = lengthMeter;
        this.resultTime = resultTime;
        this.trainingDate = trainingDate;
        this.memberCompetition = memberCompetition;
        memberCompetition.addTrainingRecord(this);

    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "Member's training records\n"   +
                "domain_model.Discipline: "  + discipline   + '\n'            +
                "Length: "      + df.format(lengthMeter) + "meter" + '\n' +
                "Time result: " + resultTime   + '\n'            +
                "Date: "        + trainingDate + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
