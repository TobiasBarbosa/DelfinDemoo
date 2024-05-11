package data_handler;

import domain_model.Member;
import domain_model.MemberCompetition;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    File file = new File("CovidData.csv");

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public ArrayList<Member> loadAllMemberCompetitionData() {
        ArrayList<Member> memberCompetitionDataList = new ArrayList<>();
        Scanner sc = null;  //hvorfor null?
        try {
            sc = new Scanner(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        MemberCompetition memberCompetitionData = null;
        while(sc.hasNext()) {
            String line = sc.nextLine(); //Split linje og læg tokens i attributer
            String[] attributes = line.split(";");
            memberCompetitionData = new MemberCompetition(
                    attributes[0],
                    attributes[1],
                    (LocalDate.parse(attributes[2])),
                    (Boolean.parseBoolean(attributes[3])),
                    (Double.parseDouble(attributes[4])),
                                (attributes[5])),
                    attributes[6]    //  dato
            ) {
            };

            memberDataList.add(memberData);

        }
        sc.close();
        return memberDataList;
    }

    //------------------------------------------------------------------------------------------------------------------
}
