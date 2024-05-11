package domain_model;
import java.util.ArrayList;

public class Team {

    //***TO DO***-------------------------------------------------------------------------------------------------------
    //TODO - Add method to Teamlist -> print error code...
    //Can we reduce code for all the different getTeam categories?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Discipline discipline; //why not accessed?!
    private String teamName;
    private boolean isSeniorTeam;
    private ArrayList<Member> teamList;
    private Coach coach;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Team(Discipline discipline, String teamName, boolean isSeniorTeam, Coach coach){
        this.discipline = discipline;
        this.teamName = teamName;
        this.isSeniorTeam = isSeniorTeam;
        this.coach = coach;
        this.teamList = new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamName(){
        return teamName;
    }

    public String isSeniorTeam(){
        return isSeniorTeam ? "Senior" : "Junior";
    }

    public String getCoach() {
        return coach.getCoachFirstName() + ' ' + coach.getCoachLastName();
    }

    public ArrayList<Member> getTeamList() {
        return teamList;
    }

    private String getTeamListAsString() {
        String teamMembers = "";
        for (Member member : teamList) {
            teamMembers += member.getMemberFirstName() + ' ' + member.getMemberLastName() + '\n';
        }
        return teamMembers;
    }

    //***GET TEAMS***---------------------------------------------------------------------
    public ArrayList<String> getAllCrawlJuniorMembers(){
        ArrayList<String> crawlJuniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Junior")){
                crawlJuniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return crawlJuniorMembers;
    }

    public ArrayList<String> getAllCrawlSeniorMembers(){
        ArrayList<String> crawlSeniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Senior")){
                crawlSeniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return crawlSeniorMembers;
    }

    public ArrayList<String> getAllButterflyJuniorMembers(){
        ArrayList<String> butterflyJuniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Junior")){
                butterflyJuniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return butterflyJuniorMembers;
    }

    public ArrayList<String> getAllButterflySeniorMembers(){
        ArrayList<String> butterflySeniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Senior")){
                butterflySeniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return butterflySeniorMembers;
    }

    public ArrayList<String> getAllBreaststrokeJuniorMembers(){
        ArrayList<String> breaststrokeJuniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Junior")){
                breaststrokeJuniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return breaststrokeJuniorMembers;
    }

    public ArrayList<String> getAllBreaststrokeSeniorMembers(){
        ArrayList<String> breaststrokeSenior = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Senior")){
                breaststrokeSenior.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return breaststrokeSenior;
    }

    public ArrayList<String> getAllBackstrokeJuniorMembers(){
        ArrayList<String> backstrokeJuniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Junior")){
                backstrokeJuniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return backstrokeJuniorMembers;
    }

    public ArrayList<String> getAllBackstrokeSeniorMembers(){
        ArrayList<String> backstrokeSeniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Senior")){
                backstrokeSeniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return backstrokeSeniorMembers;
    }

    public ArrayList<String> getAllFreestyleJuniorMembers(){
        ArrayList<String> freestyleJuniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Junior")){
                freestyleJuniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return freestyleJuniorMembers;
    }

    public ArrayList<String> getAllFreestyleSeniorMembers(){
        ArrayList<String> freestyleSeniorMembers = new ArrayList<>();
        for(Member member : teamList){
            if(discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Senior")){
                freestyleSeniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return freestyleSeniorMembers;
    }

    //***ADD & REMOVE METHODS***-----------------------------------------------------------------------------------------------------
    public void addMemberToTeam(Member member){
        if ((isSeniorTeam && member.getMemberAge() >= 18) || (!isSeniorTeam && member.getMemberAge() < 18)) {
            this.teamList.add(member);
        } else {
            System.out.println("Cannot add member to the team. Member is not eligible for this team type.");
        }
    }

    public void removeMemberOfTeam(Member member){
        this.teamList.remove(member);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Team:\n"     +
               "Team name: " + teamName       + '\n' +
               "Team Info: " + isSeniorTeam() + '\n' +
               "Coach: "     + getCoach()     + '\n' +
               "Team members: \n"             +
                getTeamListAsString();
    }

    //------------------------------------------------------------------------------------------------------------------
}
