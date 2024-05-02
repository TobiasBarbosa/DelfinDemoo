package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //calculateMemberDebt(){}
    //setIsFeePaid(){}
    //private boolean isLatestFeePaid; ??

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String firstName;
    private String lastName;
    private int memberID;
    private LocalDate dateOfBirth;
    private boolean isActiveMember;
    private String memberType;
    private double yearlyMembershipFee;
    //private boolean isLatestFeePaid; ??
    private double memberDebt;
    private ArrayList<Team> teams;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Member(String firstName, String lastName, int memberID, LocalDate dateOfBirth, boolean isActiveMember,
                  MemberType memberType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.isActiveMember = isActiveMember;
        this.memberType = memberType.toString();
        //teams.getTeamName(); //Not sure this is correct - something if member exist in Array - return teamName;
        this.yearlyMembershipFee = calculateYearlyMemberFee();

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isActiveMember() {
        return isActiveMember;
    }

    public String getMemberType() {
        return memberType;
    }

    public double getYearlyMembershipFee() {
        return yearlyMembershipFee;
    }

    public double getMemberDebt() {
        return memberDebt;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public double calculateYearlyMemberFee() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        double yearlyMembershipFee;

        if (age < 18) {
            yearlyMembershipFee = 1000.0;        // Fee for youth members under 18
        } else if (age <= 60) {
            yearlyMembershipFee = 1600.0;        // Fee for senior members between 18 and 59
        } else {
            yearlyMembershipFee = 1600.0 * 0.75; // Retiree membership fee with a 25% discount for members over 60
        }
        return yearlyMembershipFee;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Member information\n" +
                "Name: "                  + firstName      + " "  + lastName + '\n' +
                "Date of birth: "         + dateOfBirth    + '\n' +
                "Active member: "         + isActiveMember + '\n' +
                "Category: "              + memberType     + '\n' +
                "Yearly membership fee: " + df.format(yearlyMembershipFee) +" DKK\n" +
                "Debt: "                  + memberDebt     + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
