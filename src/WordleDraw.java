import codedraw.CodeDraw;

import java.awt.*;

public class WordleDraw {
    private char[] given;
    private char[] input;
    private boolean[] hashPerfect;
    private boolean[] hashExisting;
    private String givenWord;
    private String inputWord;
    private int attempts;

    public WordleDraw(int charLength, int att) {
        this.given = new char[charLength];
        this.input = new char[charLength];
        this.hashPerfect = new boolean[26];
        this.hashExisting = new boolean[26];
        for (int i = 0; i < 26; i++) {
            hashPerfect[i] = false;
            hashExisting[i] = false;
        }
        this.givenWord = "";
        this.inputWord = "";
        this.attempts = att;
    }

    public void giveWord(String word) {
        for (int i = 0; i < given.length; i++) {
            given[i] = word.charAt(i);
        }
        this.givenWord = word;
    }

    public void giveInput(String word) { // char a == int 97
        for (int i = 0; i < input.length; i++) {
            input[i] = word.charAt(i);
            if (word.charAt(i) == givenWord.charAt(i)) {
                hashPerfect[(int) word.charAt(i) - 'a'] = true;
            }

            /*
            for (int j = 0; j < 26; j++) {
                if (word.contains( "" + (char) ('a' + j))) {
                    hashExisting[j] = true;
                }
            }


            for (int j = 0; j < input.length; j++) {
                if (word.charAt(i) == givenWord.charAt(j)) {
                    hashExisting[(int) word.charAt(i) - 'a'] = true;
                }
            }
            */
            if (givenWord.contains("" + word.charAt(i))) {
                hashExisting[(int) (word.charAt(i) - 'a')] = true;
            }

        }
        this.inputWord = word;
    }

    public void drawInput(CodeDraw cd) {
        cd.setColor(Color.BLACK);
        cd.drawText(360, 100 + 80 * attempts, inputWord);

    }

    public void drawAlphabet(CodeDraw cd) {
        String perfect = "";
        String existing = "";
        for (int i = 0; i < 26; i++) {
            if (hashPerfect[i]) {
                int t = i + (int) 'a';
                perfect = perfect + (char) t + "   ";
            }
            if (hashExisting[i]) {
                int s = i + (int) 'a';
                existing = existing + (char) s + "   ";
            }
        }
        cd.setColor(Color.BLACK);
        cd.drawText(360, 600, "Fits perfectly: " + perfect);
        cd.drawText(360, 650, "Contains it: " + existing);
        cd.show();
    }



}
