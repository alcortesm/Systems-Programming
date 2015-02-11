class ParrotTest {
    public static void main(String args[]) {
        Parrot alex = new Parrot("Alex",
                new Person("Irene Pepperberg", "USA"));
        System.out.println(alex);
        System.out.println(alex.talk());
    }
}
