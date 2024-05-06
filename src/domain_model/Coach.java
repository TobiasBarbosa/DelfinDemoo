package domain_model;

public class Coach {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //What do coach need in the constructor?
    //addCompetition(){}
    //editCompetition(){}
    //addTraining(){}
    //editTraining(){}

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    String coachFirstName;
    String coachLastName;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachFirstName, String coachLastName){
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getCoachFirstName(){
        return coachFirstName;
    }

    public String getCoachLastName(){
        return coachLastName;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Coach name: " + coachFirstName + '\n';
    }
}
