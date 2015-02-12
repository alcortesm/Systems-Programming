class Parrot extends Pet {
    private final static int NUM_WINGS = 2;

    public Parrot(String name, Person owner) {
        super(name, NUM_WINGS, owner);
    }

    public String toString() {
        return "[Parrot] " + super.name + ", owned by " + super.owner;
    }

    public String talk() {
        return super.owner.name + ", " + super.owner.name + "!";
    }

    // we will need this later for pirates
    public String toStringNoOwner() {
        return "[Parrot] " + super.name;
    }
}
