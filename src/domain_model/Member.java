package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //calculateMemberDebt(){} --- single Member
    //setIsFeePaid(){}
    //private boolean isLatestFeePaid; ??
    // convert true and false to yes and no in isActiveMember()

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String memberFirstName;
    private String memberLastName;
    private int memberID;
    private LocalDate dateOfBirth;
    private boolean isActiveMember;
    private String memberType;
    private double yearlyMembershipFee;
    //private boolean isLatestFeePaid; ??
    private double memberDebt;
    private ArrayList<Team> teams;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Member(String memberFirstName, String memberLastName, int memberID, LocalDate dateOfBirth, boolean isActiveMember,
                  MemberType memberType){
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberID = memberID;
        this.dateOfBirth = dateOfBirth;
        this.isActiveMember = isActiveMember;
        this.memberType = memberType.toString();
        //teams.getTeamName(); //Not sure this is correct - something if member exist in Array - return teamName;
        this.yearlyMembershipFee = calculateYearlyMemberFee();

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getMemberFirstName() {
        return memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public int getMemberID(){
        return memberID;
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

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setActiveMember(boolean activeMember) {
        isActiveMember = activeMember;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setMemberDebt(double memberDebt) {
        this.memberDebt = memberDebt;
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
        return  "\n"                      +
                "***MEMBER'S INFORMATION" +
                "Name: "                  + memberFirstName + " "  + memberLastName + '\n' +
                "Date of birth: "         + dateOfBirth     + '\n' +
                "Active member: "         + isActiveMember  + '\n' +
                "Category: "              + memberType      + '\n' +
                "Yearly membership fee: " + df.format(yearlyMembershipFee) +" DKK\n" +
                "Debt: "                  + memberDebt      + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
