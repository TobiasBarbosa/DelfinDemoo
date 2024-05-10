package domain_model;

import java.util.ArrayList;

public class Coach {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //TODO fix toString for getCoachedMemberNamesForCompetition() so it knows which Coach the list of members is for

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    String coachFirstName;
    String coachLastName;

    private ArrayList<MemberCompetition> coachedMembers;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName){
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;

        coachedMembers = new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getCoachFirstName(){
        return coachFirstName;
    }

    public String getCoachLastName(){
        return coachLastName;
    }

    public ArrayList<String> getCoachedMemberNamesForCompetition() {
        ArrayList<String> coachedMemberNames = new ArrayList<>();
        for (MemberCompetition member : coachedMembers) {
        coachedMemberNames.add(member.getMemberFirstName() + " " + member.getMemberLastName());
         }
            return coachedMemberNames; //needs to know which coach the list is for...
    }



    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addCompetitionMemberToCoach(MemberCompetition memberCompetition){
        coachedMembers.add(memberCompetition);
    }

    public void removeCompetitionMemberFromCoach(MemberCompetition memberCompetition){
        coachedMembers.remove(memberCompetition);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Coach name: " + coachFirstName + " " + coachLastName + '\n';
    }

    //------------------------------------------------------------------------------------------------------------------
}














