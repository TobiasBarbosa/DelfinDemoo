package domain_model;

public class Coach {

    //***QUESTIONS & MISSING CODE***------------------------------------------------------------------------------------

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
        return "domain_model.Coach name: " + coachName + '\n';
    }
}
