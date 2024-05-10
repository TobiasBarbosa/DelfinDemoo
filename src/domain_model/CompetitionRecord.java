package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class CompetitionRecord extends Record{

    //QUESTIONS & MISSING CODE***---------------------------------------------------------------------------------------
    //How to insert the member in the constructor, so it connects to an actual instance?
    //Best record comparator in this class?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String event;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public CompetitionRecord(Discipline discipline, int lengthMeter, double resultTimeMinutes, LocalDate date,
                             String event){

        super(discipline,
              lengthMeter,
              resultTimeMinutes,
              date);
        this.event = event;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------


    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return  /*"***MEMBER'S COMPETITION RECORDS***\n"*/  '\n'           +
                "Discipline: "        + getDiscipline()   + '\n'           +
                "Length: "            + getLengthMeter()  + " meter"       + '\n' +
                "Time result (min): " + df.format(getResultTime()) + '\n' +
                "Date: "              + getDate()         + '\n'           +
                "Event: "             + event             + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
