package domain_model;

public class Coach {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------
    //What does coach need in the constructor?
    //addCompetition(){}
    //editCompetition(){}
    //addTraining(){}
    //editTraining(){}

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    String coachName;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Coach(String coachName){
        this.coachName = coachName;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getCoachName(){
        return coachName;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString(){
        return "Coach name: " + coachName + '\n';
    }
}
