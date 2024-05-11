package domain_model;
import comparator.RecordComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemberCollection {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //Do SearchMember() method work properly?
    //TODO - which class to place getAllSeniorMembers & getAllJuniorMembers?

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private ArrayList<Member> membersList;
    ArrayList<Record> recordList;
    Member member;
    Discipline discipline;
    RecordComparator recordComparator:

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

    public ArrayList<String> getAllJuniorMembers() {
        ArrayList<String> juniorMembers = new ArrayList<>();
        for (Member member : membersList) {
            if(member.calculateMembershipAgeGroup().equals("Junior")) {
                juniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return juniorMembers;
    }

    public ArrayList<String> getAllSeniorMembers() {
        ArrayList<String> seniorMembers = new ArrayList<>();
        for (Member member : membersList) {
            if(member.calculateMembershipAgeGroup().equals("Senior")) {
                seniorMembers.add(member.getMemberFirstName() + " " + member.getMemberLastName());
            }
        }
        return seniorMembers;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
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


    //***COMPARATOR METHODS***------------------------------------------------------------------------------------------
    //Reduced code method...
    public List<Record> findTopRecords(Discipline discipline, String ageGroup, boolean isCompetition) {
        List<Record> recordList = new ArrayList<>();
        for (Record record : this.recordList) {
            if ((isCompetition && record instanceof CompetitionRecord) || (!isCompetition && record instanceof TrainingRecord)) {
                if (record.getDiscipline() == discipline && member.calculateMembershipAgeGroup().equals(ageGroup)) {
                    recordList.add(record);
                }
            }
        }
        Collections.sort(recordList, recordComparator);

        return recordList.subList(0, 4);
    }

    public List<Record> findTopFiveCompetitionRecords(Discipline discipline, String ageGroup) {
        return findTopRecords(discipline, ageGroup, true);
    }

    public List<Record> findTopFiveTrainingRecords(Discipline discipline, String ageGroup) {
        return findTopRecords(discipline, ageGroup, false);
    }



    //***CRAWL***-------------------------------------------------------------------------------------------------------
    //Or this method, but a lot of code...
    public List<Record> findTopFiveCompetitionRecordJuniorCrawl(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Junior") ) {
                    competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveCompetitionRecordSeniorCrawl(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Senior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordJuniorCrawl(){
        ArrayList<Record> trainingRecordCrawlList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Junior") ) {
                trainingRecordCrawlList.add(record);
            }
        } Collections.sort(trainingRecordCrawlList, recordComparator); //sorterer resultTime

        return trainingRecordCrawlList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordSeniorCrawl(){
        ArrayList<Record> trainingRecordCrawlList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.CRAWL && member.calculateMembershipAgeGroup().equals("Senior") ) {
                trainingRecordCrawlList.add(record);
            }
        } Collections.sort(trainingRecordCrawlList, recordComparator); //sorterer resultTime

        return trainingRecordCrawlList.subList(0,4);
    }

    //***BUTTERFLY***---------------------------------------------------------------------------------------------------
    public List<Record> findTopFiveCompetitionRecordJuniorButterfly(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Junior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveCompetitionRecordSeniorButterfly(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Senior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordJuniorButterfly(){
        ArrayList<Record> trainingRecordButterflyList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Junior") ) {
                trainingRecordButterflyList.add(record);
            }
        } Collections.sort(trainingRecordButterflyList, recordComparator); //sorterer resultTime

        return trainingRecordButterflyList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordSeniorButterfly(){
        ArrayList<Record> trainingRecordButterflyList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BUTTERFLY && member.calculateMembershipAgeGroup().equals("Senior") ) {
                trainingRecordButterflyList.add(record);
            }
        } Collections.sort(trainingRecordButterflyList, recordComparator); //sorterer resultTime

        return trainingRecordButterflyList.subList(0,4);
    }

    //***BREASTSTROKE***------------------------------------------------------------------------------------------------
    public List<Record> findTopFiveCompetitionRecordJuniorBreaststroke(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveCompetitionRecordSeniorBreaststroke(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordJuniorBreaststroke(){
        ArrayList<Record> trainingRecordBreaststrokeList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                trainingRecordBreaststrokeList.add(record);
            }
        } Collections.sort(trainingRecordBreaststrokeList, recordComparator); //sorterer resultTime

        return trainingRecordBreaststrokeList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordSeniorBreaststroke(){
        ArrayList<Record> trainingRecordBreaststrokeList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BREASTSTROKE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                trainingRecordBreaststrokeList.add(record);
            }
        } Collections.sort(trainingRecordBreaststrokeList, recordComparator); //sorterer resultTime

        return trainingRecordBreaststrokeList.subList(0,4);
    }

    //***BACKSTROKE***--------------------------------------------------------------------------------------------------
    public List<Record> findTopFiveCompetitionRecordJuniorBackstroke(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveCompetitionRecordSeniorBackstroke(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordJuniorBackstroke(){
        ArrayList<Record> trainingRecordBackstrokeList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                trainingRecordBackstrokeList.add(record);
            }
        } Collections.sort(trainingRecordBackstrokeList, recordComparator); //sorterer resultTime

        return trainingRecordBackstrokeList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordSeniorBackstroke(){
        ArrayList<Record> trainingRecordBackstrokeList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.BACKSTROKE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                trainingRecordBackstrokeList.add(record);
            }
        } Collections.sort(trainingRecordBackstrokeList, recordComparator); //sorterer resultTime

        return trainingRecordBackstrokeList.subList(0,4);
    }

    //***FREESTYLE***---------------------------------------------------------------------------------------------------
    public List<Record> findTopFiveCompetitionRecordJuniorFreestyle(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveCompetitionRecordSeniorFreestyle(){
        ArrayList<Record> competitionRecordList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof CompetitionRecord && discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                competitionRecordList.add(record);
            }
        } Collections.sort(competitionRecordList, recordComparator); //sorterer resultTime

        return competitionRecordList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordJuniorFreestyle(){
        ArrayList<Record> trainingRecordFreestyleList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Junior") ) {
                trainingRecordFreestyleList.add(record);
            }
        } Collections.sort(trainingRecordFreestyleList, recordComparator); //sorterer resultTime

        return trainingRecordFreestyleList.subList(0,4);
    }

    public List<Record> findTopFiveTrainingRecordSeniorFreestyle(){
        ArrayList<Record> trainingRecordFreestyleList = new ArrayList<>();
        for (Record record : recordList) {
            if (record instanceof TrainingRecord && discipline == Discipline.FREESTYLE && member.calculateMembershipAgeGroup().equals("Senior") ) {
                trainingRecordFreestyleList.add(record);
            }
        } Collections.sort(trainingRecordFreestyleList, recordComparator); //sorterer resultTime

        return trainingRecordFreestyleList.subList(0,4);
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "All members:\n" +
                getMemberListAsString();
    }

    //------------------------------------------------------------------------------------------------------------------
}
