class Person {
    protected String name; // we will need it protected for parrots later
    private int numEyes;
    private String nationality;
    private final static int MIN_NUM_EYES = 0;
    private final static int MAX_NUM_EYES = 2;
    private final static int DEFAULT_NUM_EYES = 2;
    private final static String NO_NATIONALITY = "no nationality";

    public Person(String name, int numEyes, String nationality) {
        if (name == null ||
                numEyes < MIN_NUM_EYES ||
                numEyes > MAX_NUM_EYES) {
            throw new IllegalArgumentException();
        }
        // we do not check for nulls in nationality to support
        // EsproncedasPirates later.
        if (NO_NATIONALITY.equals(nationality)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.numEyes = numEyes;
        this.nationality = nationality;
    }

    public Person(String name, String nationality) {
        this(name, DEFAULT_NUM_EYES, nationality);
    }

    public String toString() {
        String eyeWord = (numEyes == 1) ? "eye" : "eyes" ;
        String nationalityWord = (nationality == null) ? NO_NATIONALITY
            : this.nationality ;
        return "[Person] " + this.name + " (" + nationalityWord +
            ", " + this.numEyes + " " + eyeWord + ")";
    }
}
