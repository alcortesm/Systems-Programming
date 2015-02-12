class PetTest {
    public static void main(String args[]) {
        Person jon = new Person("Jon Arbuckle", "USA");
        Pet gardfield = new Pet("Garfield", 0, jon);
        Pet odie = new Pet("Odie", 0, jon);

        System.out.println(gardfield);
        System.out.println(odie);
    }
}
