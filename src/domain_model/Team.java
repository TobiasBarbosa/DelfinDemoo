package domain_model;

import java.util.ArrayList;

public class Team {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String teamName;
    private String teamInfo;
    private ArrayList<Member> teamList;
    private Coach coach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(String teamName, String teamInfo, Coach coach){
        this.teamName = teamName;
        this.teamInfo = teamInfo;
        this.coach = new Coach(coach.getCoachName());
        this.teamList = new ArrayList<>();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void addMemberToTeam(Member member){
        this.teamList.add(member);
    }

    public void removeMemberofTeam(Member member){
        this.teamList.remove(member);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "domain_model.Team" +
                "domain_model.Team name: " + teamName + '\n' +
                "domain_model.Team Info: " + teamInfo + '\n' +
                "domain_model.Coach: "     + coach.getCoachName() + '\n' +
                "domain_model.Team list: " + teamList ;
    }
    //------------------------------------------------------------------------------------------------------------------
}
