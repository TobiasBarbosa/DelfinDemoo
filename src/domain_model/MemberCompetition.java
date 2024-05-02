package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCompetition extends Member{

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //How to make sure that multiple records are registered for the member?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<CompetitionRecord> competitionRecord;
    private ArrayList<TrainingRecord> trainingRecord;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberCompetition(String firstName, String lastName, int memberID, LocalDate dateOfBirth, boolean isActiveMember,
                             MemberType memberType){
        super(firstName,
              lastName,
              memberID,
              dateOfBirth,
              isActiveMember,
              memberType);
        this.competitionRecord = new ArrayList<>();
        this.trainingRecord =new ArrayList<>();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addCompetitionRecord(CompetitionRecord competitionRecord) {
        this.competitionRecord.add(competitionRecord);
    }

    public void addTrainingRecord(TrainingRecord trainingRecord) {
        this.trainingRecord.add(trainingRecord);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Member information\n" +
                "Name: "                  + getFirstName()    + " "  + getLastName() + '\n' +
                "Date of birth: "         + getDateOfBirth()  + '\n' +
                "Active member: "         + isActiveMember()  + '\n' +
                "Category: "              + getMemberType()   + '\n' +
                "Yearly membership fee: " + df.format(getYearlyMembershipFee()) +" DKK\n" +
                "Debt: "                  + getMemberDebt()   + '\n' +
                "Competition records: "   + competitionRecord + '\n' +
                "Training records: "      + trainingRecord    + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
