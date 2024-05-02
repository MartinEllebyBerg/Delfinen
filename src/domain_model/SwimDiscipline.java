package domain_model;

public enum SwimDiscipline {
    BREASTSTROKE("Breaststroke"),
    BACKSTROKE("Backstroke"),
    FRONTCRAWL("Frontcrawl"),
    BUTTERFLY("Butterfly"),
    NULL("Null");

    //ATTRIBUTES
    private String displayName;

    // CONSTRUCTOR
    SwimDiscipline(String displayName) {
        this.displayName = displayName;
    }

    //METHODS
    @Override
    public String toString() {
        return displayName;
    }
}
