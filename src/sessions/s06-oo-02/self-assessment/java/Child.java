class Child extends Person2 {
    private Person2 parent;

    public Child(String name, Nationality nationality, Person2 parent) {
        super(name, nationality);
        if (parent == null) {
            throw new IllegalArgumentException();
        }
        this.parent = parent;
    }

    public String toString() {
        return this.name + ", son of " + parent;
    }
}
