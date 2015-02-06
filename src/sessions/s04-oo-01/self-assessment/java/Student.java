class Student {
    private String name;
    private String surname;
    private int id;
    private static int howMany = 1000;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.howMany++;
        this.id = this.howMany;
    }

    public String toString() {
        return surname + ", " + name + " (" + id + ")";
    }
}
