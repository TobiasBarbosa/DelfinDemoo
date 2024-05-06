import domain_model.*;

import java.time.LocalDate;

public class Main {
    // test test

    // TODO lav x
    // TODO lav xx

    public static void main(String[] args) {

        Member member1 = new MemberCompetition("Tobias", "Barbosa", 123456,LocalDate.of(1994, 4, 26), true, MemberType.SENIOR);
        Member member2 = new MemberCompetition("Loviisa", "Mujunen", 789105,LocalDate.of(1998, 10, 10), true, MemberType.SENIOR);

        CompetitionRecord competitionRecord1 = new CompetitionRecord(Discipline.BREASTSTROKE,50, 1.07, "Bellahøj DM",LocalDate.of(2020,6,7));
        TrainingRecord trainingRecord1 = new TrainingRecord(Discipline.BUTTERFLY, 100, 2.57,"Olympics 2004", LocalDate.of(2004,1,5));

        ((MemberCompetition) member1).addCompetitionRecord(competitionRecord1);
        ((MemberCompetition) member1).addTrainingRecord(trainingRecord1);

        System.out.println(member1);
        //System.out.println(member2);
        //System.out.println(competitionRecord1);
        //System.out.println(trainingRecord1);

        // test test
    }
}
