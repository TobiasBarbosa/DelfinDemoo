package domain_model;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberCollection {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Do SearchMember() method work properly?
    //TODO - which class to place getAllSeniorMembers & getAllJuniorMembers?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Member> membersList;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberCollection(){
        this.membersList = new ArrayList<>();
    }


    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addMembersToList(Member member){
        membersList.add(member);
    }

    public void removeMemberFromList(Member member){
        membersList.remove(member);
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    private String getMemberListAsString() {
        String teamMembers = "";
        for (Member member : membersList) {
            teamMembers += member.getMemberFirstName() + ' ' + member.getMemberLastName() + '\n';
        }
        return teamMembers;
    }


    public ArrayList<String> getAllSeniorMembers() {
        ArrayList<String> seniorMembers = new ArrayList<>();
        for (Member member : membersList) {
            if(member.isActiveMember().equals("Yes")) {
                seniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return seniorMembers; //needs to know which coach the list is for...
    }

    public ArrayList<String> getAllJuniorMembers() {
        ArrayList<String> juniorMembers = new ArrayList<>();
        for (Member member : membersList) {
            if(member.isActiveMember().equals("No")) {
                juniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return juniorMembers; //needs to know which coach the list is for...
    }

    //***USER METHODS***------------------------------------------------------------------------------------------------
    public ArrayList<Member> searchMember(String membersSearched) {
        var foundMembers = new ArrayList<Member>(); //var kalder variablen, som er defineret efter new
        for (Member member : membersList) {
            if (member.getMemberFirstName().toLowerCase().contains(membersSearched.toLowerCase()) ||
                    member.getMemberLastName().toLowerCase().contains(membersSearched.toLowerCase())) {
                foundMembers.add(member);
            }
        }
        return foundMembers;
    }

    public Member findSpecificMember(String specificMemberSearched) {
        Member targetMember = null;
        for (Member memberToEdit : membersList) {
            if (memberToEdit.getMemberFirstName().equalsIgnoreCase(specificMemberSearched)) {
                targetMember = memberToEdit;
                return targetMember;
            }
        }
        return targetMember;
    }

    public Member editMember(Member memberToEdit, int partToEdit, String newValue) {

        switch (partToEdit) {
            case 1: //first name
                memberToEdit.setMemberFirstName(newValue);
                break;

            case 2: //last name
                memberToEdit.setMemberLastName(newValue);
                break;

            case 3: //date of birth
                memberToEdit.setDateOfBirth(LocalDate.parse(newValue));
                break;

            case 4: //isActive
                memberToEdit.setActiveMember(Boolean.parseBoolean(newValue));
                break;

            case 5: //debt
                memberToEdit.setMemberDebt(Double.parseDouble(newValue));
                break;

            case 0: //exit
                break;
        }
        return memberToEdit;
    }

    public boolean removeMember(String memberToDelete){
        Member targetMember = findSpecificMember(memberToDelete);
        if (targetMember != null){
            membersList.remove(targetMember);
            //fileHandler.saveMovieToFile(movieList);
            return true;
        } else {
            return false;
        }
    }

    public double calculateTotalYearlyMembershipIncome(){
        double totalFee = 0.0;

        for (Member member : membersList){
            totalFee += member.calculateYearlyMemberFee();
        }
        return totalFee;
    }

    public double calculateTotalDebt(){ //tjek om det er korrekt
        double totalDebt = 0;
        for(Member debt : membersList){
            totalDebt += debt.getMemberDebt();
        }
        return totalDebt;
    }

    public ArrayList<Member> searchMemberDebt(String membersSearchedDebt) {
        var foundMembersDebt = new ArrayList<Member>(); //var kalder variablen, som er defineret efter new
        for (Member member : membersList) {
            if (member.getMemberDebt() > 0) {
                foundMembersDebt.add(member);
            }
        }
        return foundMembersDebt;
    }



    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "All members:\n" +
                getMemberListAsString();
    }

    //------------------------------------------------------------------------------------------------------------------
}
