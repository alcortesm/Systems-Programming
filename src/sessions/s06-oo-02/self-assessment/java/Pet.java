class Pet extends Animal {
    protected Person owner; // we will need this protected for parrots later

    public Pet(String name, int numWings, Person owner) {
        super(name, numWings);
        if (owner == null) {
            throw new IllegalArgumentException();
        }
        this.owner = owner;
    }

    public String toString() {
        return super.toString() + ", owned by " + this.owner;
    }
}
