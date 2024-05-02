package domain_model;

public enum Discipline {

    //***ENUMS***-------------------------------------------------------------------------------------------------------
    CRAWL       ("Crawl"),
    BREASTSTROKE("Breaststroke"),
    BACKSTROKE  ("Backstroke"),
    BUTTERFLY   ("Butterfly"),
    FREESTYLE   ("Freestyle");

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final String displayName;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    Discipline(String displayName) {
        this.displayName = displayName;
    }

    //***TO STRING METHOD***--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return displayName;
    }

    //------------------------------------------------------------------------------------------------------------------
}
