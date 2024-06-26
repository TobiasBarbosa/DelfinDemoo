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
    //how to approach ArrayList when loading to the file?

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
        while(sc.hasNext()) { // forstår ikke
            String line = sc.nextLine(); //Split linje og læg tokens i attributer // forstår ikke
            String[] attributes = line.split(";");
            memberCompetitionData = new MemberCompetition(
                    attributes[0],
                    attributes[1],
                    (LocalDate.parse(attributes[2])),
                    (Boolean.parseBoolean(attributes[3])),
                    (Double.parseDouble(attributes[4])), //
                    //How do we get an ArrayList in here?
            ) {
            };

            memberCompetitionDataList.add(memberCompetitionData);

        }
        sc.close();
        return memberCompetitionDataList;
    }

    //------------------------------------------------------------------------------------------------------------------
}
