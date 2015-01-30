import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class UltimateQuestion {
    public static void main(String args[]) {
        System.out.print("What is the Answer to The Ultimate Question ");
        System.out.println("of Life, the Universe, and Everything?");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = null;
        try {
            answer = br.readLine();
        } catch (IOException ex) {
            System.err.println(ex);
            System.exit(1);
        }

        if (answer.equals("42") ||
                answer.equalsIgnoreCase("forty-two")) {
            System.out.println("RIGHT!");
        } else {
            System.out.println("WRONG!");
        }
    }
}
