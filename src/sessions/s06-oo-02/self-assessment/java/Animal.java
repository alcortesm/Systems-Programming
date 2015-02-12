class Animal {
    protected String name; // we will need it protected for parrots later
    private int numWings;
    private final static int MIN_NUM_WINGS = 0;
    private final static int MAX_NUM_WINGS = 4;
    private final static int DEFAULT_NUM_WINGS = 0;

    public Animal(String name, int numWings) {
        if (name == null ||
                numWings < MIN_NUM_WINGS ||
                numWings > MAX_NUM_WINGS) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.numWings = numWings;
    }

    public Animal(String name) {
        this(name, DEFAULT_NUM_WINGS);
    }

    public String toString() {
        String wingWord = (numWings == 1) ? "wing" : "wings";
        return "[Animal] " + this.name + " (" + this.numWings + " " +
            wingWord + ")";
    }
}
