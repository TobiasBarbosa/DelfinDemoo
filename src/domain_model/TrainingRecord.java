package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class TrainingRecord extends Record {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //best record comparator in this class?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public TrainingRecord(Discipline discipline, int lengthMeter, double resultTime, LocalDate date){
        super(discipline,
              lengthMeter,
              resultTime,
              date);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
   @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return  /*"***MEMBER'S TRAINING RECORDS***\n"+*/ '\n'         +
                "Discipline: "  + getDiscipline()   + '\n'            +
                "Length: "      + df.format(getLengthMeter()) + " meter" + '\n' +
                "Time result: " + getResultTime()   + '\n'            +
                "Date: "        + getDate()         + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}
