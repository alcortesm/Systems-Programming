class ChildTest {
    public static void main(String args[]) {
        Person2 argonui = new Person2("Argonui", Nationality.DUNEDAIN);
        Child arador = new Child("Arador", Nationality.DUNEDAIN, argonui);
        Child arathorn = new Child("Arathorn", Nationality.DUNEDAIN, arador);
        Child aragorn = new Child("Aragorn", Nationality.DUNEDAIN, arathorn);

        System.out.println(aragorn);
    }
}
