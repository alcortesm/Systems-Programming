class Pirate extends Person {

    private Parrot parrot;
    private static final int NUM_EYES = 1;

    // you cannot pass a parrot as an argument because
    // parrots are pets, and pets needs an owner that 
    // has not yet been created (we are creating it with
    // this constructor).
    //
    // The only solution is to create both objects in the
    // same constructor.
    public Pirate(String pirateName, String nationality, String parrotName) {
        super(pirateName, NUM_EYES, nationality);
        parrot = new Parrot(parrotName, this);
    }

    public String toString() {
        // if you simply concatenate parrot at the end of this
        // you will get a StackOverFlowError.
        return super.toString() + ", owner of " + parrot.toStringNoOwner();
    }

    public Parrot getParrot() {
        return parrot;
    }
}
