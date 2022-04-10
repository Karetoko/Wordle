import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordList {
    private String[] list;
    private String selected;
    private int pos;
    private int charSize;

    private final int SHORT = 2184;
    private final int MEDIUM = 5459;
    private final int LONG = 2241;


    public WordList(int attempts, int size) throws IOException {
        this.list = new String[attempts];
        this.charSize = size;
        this.pos = 0;
        this.selected = "";

    }

    public void randSelect() throws IOException {
        int random = 0;
        boolean selected = false;
        int count = 0;
        String word = "";
        if (charSize <= 4) {
            random = (int) (Math.random() * SHORT);
        } else if (charSize <= 8) {
            random = (int) (Math.random() * MEDIUM);
        } else {
            random = (int) (Math.random() * LONG);
        }

        while (!selected) {
            if (charSize <= 4) {
                word = Files.readAllLines(Paths.get("./src/en_US_10000_short.txt")).get(random + count);
            } else if (charSize <= 8) {
                word = Files.readAllLines(Paths.get("./src/en_US_10000_medium.txt")).get(random + count);
            } else if (charSize >= 9) {
                word = Files.readAllLines(Paths.get("./src/en_US_10000_long.txt")).get(random + count);
            }

            if (word.length() != charSize) {
                if (random > 1800) {
                    count--;
                } else {
                    count++;
                }
            } else {
                selected = true;
            }
        }
        this.selected = word;
    }

    public boolean isWord(String word) throws IOException {
        int start = 1;
        int end = 0;
        if (charSize <= 4) {
            end = SHORT;
        } else if (charSize <= 8) {
            end = MEDIUM;
        } else {
            end = LONG;
        }
        int mid = end/2;
        String midWord = "";

        while (start + 1 < end) {
            if (charSize <= 4) {
                midWord = Files.readAllLines(Paths.get("./src/en_US_10000_short.txt")).get(mid);
            } else if (charSize <= 8) {
                midWord = Files.readAllLines(Paths.get("./src/en_US_10000_medium.txt")).get(mid);
            } else {
                midWord = Files.readAllLines(Paths.get("./src/en_US_10000_long.txt")).get(mid);
            }
            char value = direction(midWord, word);
            if (value == 'f') {
                return true;
            } else if (value == 'l') {
                end = mid;
                mid = start + (end - start)/2;
            } else if (value == 'r') {
                start = mid;
                mid = start + (end - start)/2;
            }
        }
        return false;
    }

    private char direction(String target, String given) { // given normally the constant, target is the "mid" in a binary search
        char[] targetArray = new char[target.length()]; // transfer String to a char array
        char[] givenArray = new char[given.length()];
        for (int i = 0; i < target.length(); i++) {
            targetArray[i] = target.charAt(i);
        }
        for (int i = 0; i < given.length(); i++) {
            givenArray[i] = given.charAt(i);
        }

        int count = 0;
        boolean terminate = false; // keyword for when the following while-loop shall stop
        boolean found = false; // if a word has been actually found
        boolean smaller = false; // if given word is alphabetically smaller that target word (note: only one boolean used here for simplicity)
        while (!terminate) {
            if (targetArray[count] == givenArray[count]) {
                count++;
            } else if (targetArray[count] > givenArray[count]) { // e.g. 'k' > 'c' --> case-sensitive! given smaller.
                smaller = true;
                terminate = true;
            } else { // targetArray[count] < givenArray[count]
                terminate = true;
            }

            if (target.equals(given)) { // when found
                found = true;
                terminate = true;
            }

            if (count == targetArray.length) { // given larger
                terminate = true;
            } else if (count == givenArray.length) { // given smaller
                terminate = true;
                smaller = true;
            }

        }
        if (found) {
            return 'f'; // 'f' for found
        } else if (smaller) {
            return 'l'; // 'l' for left
        } else if (!smaller) {
            return 'r'; // 'r' for right
        }
        return 'e'; // 'e' for error
    }

}
