import domain_model.CompetitionRecord;
import domain_model.Member;
import domain_model.MemberCompetition;
import domain_model.MemberType;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Member member1 = new MemberCompetition("Tobias", "Barbosa", LocalDate.of(1994, 4, 26), true, MemberType.SENIOR);

        System.out.println(member1);
    }
}
