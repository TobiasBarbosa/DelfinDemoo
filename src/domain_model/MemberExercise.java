package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MemberExercise extends Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Do we need any attributes for the constructor?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberExercise(String firstName, String lastName, LocalDate dateOfBirth, boolean isActiveMember,
                          MemberType memberType){
        super(firstName,
              lastName,
              dateOfBirth,
              isActiveMember,
              memberType);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "domain_model.Member information\n" +
                "Name: "                  + getFirstName()   + " "  + getLastName() + '\n' +
                "Date of birth: "         + getDateOfBirth() + '\n' +
                "Active member: "         + isActiveMember() + '\n' +
                "Category: "              + getMemberType()  + '\n' +
                "Yearly membership fee: " + df.format(getYearlyMembershipFee()) +" DKK\n" +
                "Debt: "                  + getMemberDebt()  + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
