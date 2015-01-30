import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Eleet {
    static char[] oldChars = {'a', 'e', 'i', 'o', 'I'};
    static char[] newChars = {'4', '3', '1', '0', '1'};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String inputLine = null;
        String outputLine = null;

        while (true) {
            try {
                inputLine = br.readLine();
            } catch (IOException ex) {
                System.err.println(ex);
                System.exit(1);
            }
            if (inputLine == null) {
                break;
            }

            outputLine = new String(inputLine);
            for (int i=0; i<oldChars.length; i++) {
                outputLine = outputLine.replace(oldChars[i], newChars[i]);
            }
            System.out.println(outputLine);
        }

        System.exit(0);
    }
}
