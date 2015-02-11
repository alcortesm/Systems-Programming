final class Nationality {

    private String name;

    public final static Nationality SPANISH = new Nationality("Spanish");
    public final static Nationality ENGLISH = new Nationality("English");
    public final static Nationality NORTH_AMERICAN = new Nationality("North American");
    public final static Nationality ITALIAN = new Nationality("Italian");
    public final static Nationality FRENCH = new Nationality("French");
    public final static Nationality UNKNOWN = new Nationality("unknown");
    public final static Nationality UNSUPPORTED = new Nationality("unsupported");
    public final static Nationality NO_NATIONALITY = new Nationality("no nationality");

    private Nationality(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}
