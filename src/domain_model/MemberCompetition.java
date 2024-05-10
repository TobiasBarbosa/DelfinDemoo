package domain_model;
import comparator.RecordComparator;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class MemberCompetition extends Member{

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //How to properly use the super() function in the constructor as a subclass?
    //TODO comparator class for record
    //How do we use the comparator methods?
    //find the best training result for all members

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<CompetitionRecord> competitionRecord;
    private ArrayList<TrainingRecord>    trainingRecord;
    private ArrayList<Team>              teams;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MemberCompetition(String memberFirstName, String memberLastName, LocalDate dateOfBirth,
                             boolean isActiveMember, double memberDebt){

        super(memberFirstName,
              memberLastName,
              dateOfBirth,
              isActiveMember,
              memberDebt);
        this.teams = new ArrayList<>();
        this.competitionRecord = new ArrayList<>();
        this.trainingRecord =   new ArrayList<>();
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getTeamsForSpecificMember() {
        ArrayList<String> memberTeams = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamList().contains(this)) {
                memberTeams.add(team.getTeamName());
            }
        }
        return getMemberFirstName() + " " + getMemberLastName() + ":\n" + memberTeams;
    }

    public ArrayList<CompetitionRecord> getMemberRecord(){
    return competitionRecord;
    }

    //***ADD & REMOVE METHODS***----------------------------------------------------------------------------------------
    public void addCompetitionRecord(CompetitionRecord competitionRecord) {
        this.competitionRecord.add(competitionRecord);
    }

    public void addTrainingRecord(TrainingRecord trainingRecord) {
        this.trainingRecord.add(trainingRecord);
    }

    public void addTeamForSpecificMember(Team team) {
        this.teams.add(team);
    }

    public void removeTeamForSpecificMember(Team team) {
        this.teams.remove(team);
    }

    //***COMPARATOR METHODS***------------------------------------------------------------------------------------------
    public Record findBestTrainingRecord(){
        ArrayList<Record> trainingRecordList = new ArrayList<>();
        for (Record record : trainingRecord) {
            if (record instanceof TrainingRecord) {
                trainingRecordList.add(record);
            }
        } Collections.sort(trainingRecordList, new RecordComparator()); //sorterer resultTime
        return (trainingRecordList.get(0)); //henter index 0 og retunerer den
    }

    public Record findBestCompetetionRecord(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : competitionRecord) {
            if (record instanceof CompetitionRecord) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, new RecordComparator()); //sorterer resultTime
        return (competitionRecordList.get(0)); //henter index 0 og retunerer den
    }



    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");

        return  "***MEMBER'S INFORMATION***\n" +
                "Name: "                       + getMemberFirstName()     + " "  + getMemberLastName()  + '\n' +
                "Member ID: "                  + getMemberID()            + '\n' +
                "Date of birth: "              + getDateOfBirth()         + '\n' +
                "Active member: "              + isActiveMember()         + '\n' +
                "Senior or Junior: "           + getMembershipAgeGroup()  + '\n' +
                "Yearly membership fee: "      + df.format(getYearlyMembershipFee()) + " DKK\n" +
                "Debt: "                       + df.format(getMemberDebt())          + " DKK\n" +
                "Teams for "                   + getTeamsForSpecificMember()                 + '\n'     +
                "Competition records: "        + competitionRecord + '\n' +
                "Training records: "           + trainingRecord    + '\n' ;
    }

    //------------------------------------------------------------------------------------------------------------------
}
