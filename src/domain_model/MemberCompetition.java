package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MemberCompetition extends Member{

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //How to make sure that multiple records are registered for the member?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private CompetitionRecord competitionRecord;
    private TrainingRecord trainingRecord;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberCompetition(String firstName, String lastName, LocalDate dateOfBirth, boolean isActiveMember,
                             MemberType memberType){
        super(firstName,
              lastName,
              dateOfBirth,
              isActiveMember,
              memberType);
        //this.competitionRecord = ?
        //this.trainingRecord = ?;

    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "domain_model.Member information\n" +
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
