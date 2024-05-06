package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MemberExercise extends Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Do we need any attributes for the constructor?
    //we need teams inside the constructor
    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberExercise(String firstName, String lastName, int memberID, LocalDate dateOfBirth, boolean isActiveMember,
                          MemberType memberType){
        super(firstName,
              lastName,
              memberID,
              dateOfBirth,
              isActiveMember,
              memberType);
              //teams)
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return  "***MEMBER'S INFORMATION***\n" +
                "Name: "                       + getMemberFirstName()    + " "  + getMemberLastName() + '\n' +
                "Date of birth: "              + getDateOfBirth() + '\n' +
                "Active member: "              + isActiveMember() + '\n' +
                "Category: "                   + getMemberType()  + '\n' +
                "Yearly membership fee: "      + df.format(getYearlyMembershipFee()) +" DKK\n" +
                "Debt: "                       + getMemberDebt()  + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
