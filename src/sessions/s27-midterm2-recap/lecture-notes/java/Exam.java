class Exam {

    public static void main(String args[]) {
        Stack s = new ExamStack();

        System.out.println("-----------");
        show(s); // this must print nothing
        System.out.println("-- again --");
        show(s); // this must print nothing
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(3);
        show(s); // this must print 3
        System.out.println("-- again --");
        show(s); // this must print 3
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(5);
        show(s); // this must print 5 and 3
        System.out.println("-- again --");
        show(s); // this must print 5 and 3
        System.out.println("-----------");

        System.out.println("-----------");
        s.push(7);
        show(s); // this must print 7, 5 and 3
        System.out.println("-- again --");
        show(s); // this must print 7, 5 and 3
        System.out.println("-----------");
    }

    private static void show(Stack s) {
        show7(s);
    }

    private static void show1(Stack s) {
        if (s.empty()) {
            return;
        }
        while( ! s.empty()) {
            System.out.println(s.pop());
        }
    }

    private static void show2(Stack s) {
        if (s.empty()) {
            return;
        }

        // Pop all elements, saving them into an arraylist
        // and printting them
        java.util.ArrayList<Integer> al =
            new java.util.ArrayList<Integer>();
        int extracted;
        while( ! s.empty()) {
            extracted = s.pop();
            al.add(extracted); // adds at the end
            System.out.println(extracted);
        }

        // Now restore all the elements from the arraylist
        // into the stack.
        for (int i=0; i<al.size(); i++) {
            s.push(al.get(i));
        }
    }

    private static void show3(Stack s) {
        if (s.empty()) {
            return;
        }

        // Pop all elements, saving them into an arraylist
        // and printting them
        java.util.ArrayList<Integer> al =
            new java.util.ArrayList<Integer>();
        int extracted;
        while( ! s.empty()) {
            extracted = s.pop();
            al.add(extracted); // adds at the end
            System.out.println(extracted);
        }

        // Now restore all the elements from the arraylist
        // into the stack in reverse order.
        for (int i=al.size()-1; i>=0; i--) {
            s.push(al.get(i));
        }
    }

    private static void show4(Stack s) {
        if (s.empty()) {
            return;
        }

        // Pop all elements, saving them into an array
        // and printting them
        int[] array = new int[10];
        int counter = 0;
        int extracted;
        while( ! s.empty()) {
            // if array is too small, make it bigger
            // this is like the grow method from the ArrayStack.
            if (counter == array.length) {
                int newLenght = array.length * 2;
                int[] newArray = new int[newLenght];
                for (int i=0; i<array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }
            extracted = s.pop();
            array[counter++] = extracted;
            System.out.println(extracted);
        }

        // Now restore all the elements from the array
        // into the stack in reverse order.
        for (int i=counter-1; i>=0; i--) {
            s.push(array[i]);
        }
    }

    private static void show5(Stack s) {
        if (s.empty()) {
            return;
        }

        Stack aux = new ExamStack();
        int extracted;
        while( ! s.empty()) {
            extracted = s.pop();
            aux.push(extracted);
            System.out.println(extracted);
        }

        // Now restore all the elements from the aux stack
        // into the original stack.
        while ( ! aux.empty()) {
            s.push(aux.pop());
        }
    }

    private static void show6(Stack s) {
        if (s.empty()) { // base case
            return;
        } else { // recursive case
            System.out.println(s.pop());
            show6(s);
        }
    }

    private static void show7(Stack s) {
        if ( s.empty()) { // base case
            return;
        } else { // recursive case
            int extracted = s.pop();
            System.out.println(extracted);
            show7(s);
            s.push(extracted);
        }
    }
}
