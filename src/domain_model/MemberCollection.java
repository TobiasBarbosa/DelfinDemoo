package domain_model;
import java.util.ArrayList;

public class MemberCollection {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //editMember(){} in this class or in domain_model.Member class?
    //viewMembersInDebt(){}

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Member> membersList;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberCollection(){
        this.membersList = new ArrayList<>();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMembersToList(Member member){
        membersList.add(member);
    }

    public void removeMember(Member member){
        membersList.remove(member);
    }

    public ArrayList<Member> searchMember(String userInput) {
        ArrayList<Member> foundMembers = new ArrayList<>();

        // Convert the userInput to lowercase for letter-case comparison
        String lowercaseUserInput = userInput.toLowerCase();

        for (Member member : membersList) {
            String lowercaseName = member.getFirstName().toLowerCase();
            String lowercaseLastName = member.getLastName().toLowerCase();

            if (lowercaseName.contains(lowercaseUserInput) || lowercaseLastName.contains(lowercaseUserInput)) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    public double calculateTotalYearlyMembershipIncome(){
        double totalFee = 0.0;

        for (Member member : membersList){
            totalFee += member.calculateYearlyMemberFee();
        }
        return totalFee;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "All members: " + membersList;//.getName - only needs to print names, right?
    }
    //------------------------------------------------------------------------------------------------------------------
}
