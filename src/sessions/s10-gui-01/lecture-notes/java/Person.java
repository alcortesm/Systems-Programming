class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addOneYear() {
        this.age++;
    }

    public String toString() {
        return "Person(" + this.name +
            ", " + this.age + ")";
    }
}
