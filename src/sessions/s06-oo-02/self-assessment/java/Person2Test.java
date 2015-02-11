class Person2Test {
    public static void main(String args[]) {

        Person2 p = new Person2("Alberto", Nationality.SPANISH);
        System.out.println(p);

        p = new Person2("John", Nationality.NORTH_AMERICAN);
        System.out.println(p);

        p = new Person2("Andrea", Nationality.ITALIAN);
        System.out.println(p);

        p = new Person2("Pierre", Nationality.UNSUPPORTED);
        System.out.println(p);

        p = new Person2("Jack Sparrow", Nationality.NO_NATIONALITY);
        System.out.println(p);

        p = new Person2("Batman", Nationality.UNKNOWN);
        System.out.println(p);

    }
}
