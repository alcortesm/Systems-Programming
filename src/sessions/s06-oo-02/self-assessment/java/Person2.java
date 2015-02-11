class Person2 {
    protected String name;
    private int numEyes;
    private Nationality nationality;
    private final static int MIN_NUM_EYES = 0;
    private final static int MAX_NUM_EYES = 2;
    private final static int DEFAULT_NUM_EYES = 2;

    public Person2(String name, int numEyes, Nationality nationality) {
        if (name == null ||
                nationality == null ||
                numEyes < MIN_NUM_EYES ||
                numEyes > MAX_NUM_EYES) {
            throw new IllegalArgumentException();
                }
        this.name = name;
        this.numEyes = numEyes;
        this.nationality = nationality;
    }

    public Person2(String name, Nationality nationality) {
        this(name, DEFAULT_NUM_EYES, nationality);
    }

    public String toString() {
        String eyeWord = (numEyes == 1) ? "eye" : "eyes" ;
        return "[Person2] " + this.name + " (" + nationality +
            ", " + this.numEyes + " " + eyeWord + ")";
    }
}
