package domain_model;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;

public abstract class Member {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String    memberFirstName;
    private String    memberLastName;
    private int       memberID;
    private LocalDate dateOfBirth;
    private boolean   isActiveMember;
    private double    yearlyMembershipFee;
    private String    membershipAgeGroup;
    private double    memberDebt;

    private static int nextMemberID = 1;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Member(String memberFirstName, String memberLastName, LocalDate dateOfBirth,
                  boolean isActiveMember, double memberDebt){

        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberID = generateMemberID();
        this.dateOfBirth = dateOfBirth;
        this.isActiveMember = isActiveMember;
        this.memberDebt = memberDebt;
        this.yearlyMembershipFee = calculateYearlyMemberFee();
        this.membershipAgeGroup = calculateMembershipAgeGroup();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getMemberFirstName() {
        return memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public String getFullMemberName(){
        return memberFirstName + " " + memberLastName;
    }

    public int getMemberID(){
        return memberID;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String isActiveMember() {
        return (true) ? "Yes" : "No";
    }

    public double getYearlyMembershipFee() {
        return yearlyMembershipFee;
    }

    public double getMemberDebt() {
        return memberDebt;
    }

    public String getMembershipAgeGroup() {
        return membershipAgeGroup;
    }

    public int getMemberAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
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

    public void setMemberDebt(double memberDebt) {
        this.memberDebt = memberDebt;
    }


    //***METHODS***-----------------------------------------------------------------------------------------------------
    public int generateMemberID() {
        int id = nextMemberID;
        nextMemberID++; // Increment the static counter for the next member
        return id;
    }

    public String calculateMembershipAgeGroup() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();

        if (age < 18) {
            return "Junior";
        } else {
            return "Senior";
        }
    }

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

    //------------------------------------------------------------------------------------------------------------------
}
