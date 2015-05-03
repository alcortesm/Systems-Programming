class Exam {
    public static void main(String args[]) {
        Stack s = new ExamStack();

        System.out.println("-----------");
        show(s);
        System.out.println("-- again --");
        show(s);
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(3);
        show(s);
        System.out.println("-- again --");
        show(s);
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(5);
        show(s);
        System.out.println("-- again --");
        show(s);
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(7);
        show(s);
        System.out.println("-- again --");
        show(s);
        System.out.println("-----------");
    }

    private static void show(Stack s) {
        //
        // WRITE THIS METHOD USING RECURSION
        //
    }
}
