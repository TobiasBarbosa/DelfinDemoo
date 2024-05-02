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

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamName(){
        return teamName;
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
        return "Team" +
               "Team name: " + teamName + '\n' +
               "Team Info: " + teamInfo + '\n' +
               "Coach: "     + coach.getCoachName() + '\n' +
               "Team list: " + teamList ;
    }
    //------------------------------------------------------------------------------------------------------------------
}
