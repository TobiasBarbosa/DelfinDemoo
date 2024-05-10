import domain_model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //***INSTANCES***-----------------------------------------------------------------------------------------------
        MemberCollection memberCollection = new MemberCollection();

        //***COACHES***-------------------------------------------------------------------------------------------------
        Coach coach1 = new Coach("Monir", "Mooghen");
        Coach coach2 = new Coach("Francisca", "Barbosa");

        //***TEAMS***---------------------------------------------------------------------------------------------------
        Team team1 = new Team(Discipline.BREASTSTROKE,"Team 1", "Senior 50 meter",
                              true, coach1);

        Team team2 = new Team(Discipline.BUTTERFLY, "Team 2", "Senior 100 meter",
                              true, coach2);

        //***MEMBER 1***------------------------------------------------------------------------------------------------
        MemberCompetition member1 = new MemberCompetition("Tobias", "Barbosa",
                                                          LocalDate.of(1994, 4, 26),
                                                          true, 1600);

        CompetitionRecord competitionRecord1 = new CompetitionRecord(Discipline.BREASTSTROKE,50,
                                                                     1.07, LocalDate.of(2020,6,
                                                                     7),"Bellahøj DM");

        TrainingRecord trainingRecord1 = new TrainingRecord(Discipline.BUTTERFLY, 100, 2.57,
                                                            LocalDate.of(2004, 1,5));

        member1.addCompetitionRecord(competitionRecord1);
        member1.addTrainingRecord(trainingRecord1);
        memberCollection.addMembersToList(member1);
        team1.addMemberToTeam(member1);
        member1.addTeamForSpecificMember(team1);
        coach1.addCompetitionMemberToCoach(member1);

        //***MEMBER 2***------------------------------------------------------------------------------------------------
        MemberCompetition member2 =
                new MemberCompetition("Loviisa", "Mujunen",
                                      LocalDate.of(2001, 10, 10), true,
                                      1600);

        CompetitionRecord competitionRecord2 =
                new CompetitionRecord(Discipline.CRAWL,400, 2.67,
                                      LocalDate.of(2018,6, 7), "WC AUCKLAND");


        TrainingRecord trainingRecord2 =
                new TrainingRecord(Discipline.FREESTYLE, 100, 0.57,
                                   LocalDate.of(2020, 1,5));

        member2.addCompetitionRecord(competitionRecord2);
        member2.addTrainingRecord(trainingRecord2);
        memberCollection.addMembersToList(member2);
        team1.addMemberToTeam(member2);
        member2.addTeamForSpecificMember(team1);
        team2.addMemberToTeam(member2);
        member2.addTeamForSpecificMember(team2);

        //***MEMBER 3***------------------------------------------------------------------------------------------------
        MemberCompetition member3 =
                new MemberCompetition("Patrick", "Gboublé",
                                      LocalDate.of(2018,6,6), true,
                                      1000);

        team1.addMemberToTeam(member3);
        member3.addTeamForSpecificMember(team1);
        memberCollection.addMembersToList(member3);


        //***PRINT OUTS***----------------------------------------------------------------------------------------------
        System.out.println(memberCollection.getAllSeniorMembers());
        //System.out.println(member1);
        //System.out.println(team1);
        //System.out.println(member2);
        //System.out.println(team2);
        //System.out.println(member3);
        //System.out.println(coach1.getCoachFirstName() + " " + coach1.getCoachLastName() + " is trainer for:\n" +
        //                     coach1.getCoachedMemberNamesForCompetition());


    //------------------------------------------------------------------------------------------------------------------
    }
}
