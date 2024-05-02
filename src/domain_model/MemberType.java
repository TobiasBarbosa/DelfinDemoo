package domain_model;

public enum MemberType {

    //***ENUMS***-------------------------------------------------------------------------------------------------------
    JUNIOR      ("Junior"),
    SENIOR      ("Senior"),
    EXERCISER   ("Exerciser"),
    COMPETITION ("Competition");

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final String displayName;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    MemberType(String displayName) {
        this.displayName = displayName;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return displayName;
    }

    //------------------------------------------------------------------------------------------------------------------
}
