package domain_model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MemberExercise extends Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Do we need any additional attributes for the constructor?
    //we need teams inside the constructor
    //How to properly use the super() function in the constructor as a subclass?

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberExercise(String memberFirstName, String memberLastName, LocalDate dateOfBirth,
                          boolean isActiveMember, double memberDebt){

        super(memberFirstName,
              memberLastName,
              dateOfBirth,
              isActiveMember,
              memberDebt);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");

        return  "***MEMBER'S INFORMATION***\n" +
                "Name: "                       + getMemberFirstName()    + " "  + getMemberLastName() + '\n' +
                "Member ID: "                  + getMemberID()           + '\n' +
                "Date of birth: "              + getDateOfBirth()        + '\n' +
                "Active member: "              + isActiveMember()        + '\n' +
                "Senior or Junior: "           + getMembershipAgeGroup() + '\n' +
                "Yearly membership fee: "      + df.format(getYearlyMembershipFee()) + " DKK\n" +
                "Debt: "                       + df.format(getMemberDebt())          + " DKK\n" ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
