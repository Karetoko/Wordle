import codedraw.CodeDraw;
import codedraw.events.EventScanner;
import codedraw.textformat.HorizontalAlign;
import codedraw.textformat.TextFormat;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        // TODO: Implement the game "Wordle"!
        // INFO: short: 1-4, medium: 5-8, long: 9+ --> American English
        /*
        What I will probably need:
         - A library with all the needed words (English, but also doable in German or any other alphabetical language). Should be somewhat efficient (binary search via char?).
         - A class "Word" which contains length, type (noun,..) and other useful information.
         - A class "LetterList" which saves the letters used/correct/still left.
         - A class "Visual" for the visual part of this application. Can be done with CodeDraw (or equivalent) or in the terminal.

         What variables should be available for the user to customize?
         - Let user choose the lenght at which word should be played with [min: 4, max: maybe 10? Just shouldn't bee too long, because the search will be slow by then probably]
         - Let user choose how many guesses he/she can do [min: 4, max: 8]
         - optional: Let user choose what kind of words he should guess (e.g. noun, verb, adjective,...)

         What should be returned to be visible for the user?
         - The correct/incorrect/somewhat correct letters from the word. When done in console: return as array list.
         - How many guesses are left.
         - What guesses have been made.

         Challenges for me personally:
         - I have NO IDEA how to work with libraries. Like nada, none.
         - How to confront this project regarding workflow and such.
         - Maybe APIs will be needed here, which would open some completely new topics to me (and I don't have that much time lmao)
         - optional: I had the idea of working with mouse scanners, but this might add an extra layer of complexity.
        */
        CodeDraw cd =  new CodeDraw(720,720);
        TextFormat format = cd.getTextFormat();
        format.setFontName("Bahnschrift");
        format.setHorizontalAlign(HorizontalAlign.CENTER);
        Scanner scanner = new Scanner(System.in);
        EventScanner eScanner = new EventScanner(cd);

        cd.setColor(Color.BLACK);
        cd.fillRectangle(0,0, 720,720);
        cd.show();
        cd.show(2000);

        for (int i = 0; i < 256; i++) {
            Color var = new Color(i,i,i);
            cd.setColor(var);
            cd.fillRectangle(0,0, 720,720);
            cd.show(10);
        }
        cd.setColor(Color.BLACK);
        format.setFontSize(50);
        cd.drawText(360, 180, "Welcome to Wordle!");
        cd.show(2000);
        format.setFontSize(32);
        cd.drawText(360, 600, "Press \"Enter\" (in console) to continue");
        cd.show();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            //this code will be executed after user pressed enter
            cd.clear();
            cd.show();
            System.out.println("Welcome!");
        } catch (IOException e) {
            //handle exception
            cd.drawText(360, 700, "Invalid input!");
            cd.show();
        }

        /*
        cd.onKeyDown(a -> {
            System.out.println("test");
        });
        */

        cd.show(1000);
        format.setFontSize(40);
        cd.drawText(360, 180, "How long should the word be?");
        cd.show(1000);
        format.setFontSize(25);
        cd.drawText(360, 250, "Allowed length: 4 - 10 characters");
        cd.show();

        boolean correctEnter = false;
        int wordLength = 0;
        format.setFontSize(50);
        while (!correctEnter) {
            if (scanner.hasNextInt()) {
                wordLength = scanner.nextInt();
                if (wordLength < 4 || wordLength > 10) {
                    System.out.println("Invalid input!");

                    cd.setColor(Color.WHITE);
                    cd.fillRectangle(0, 350, 720, 300);
                    cd.show();
                    cd.setColor(Color.BLACK);

                    if (wordLength == 420 || wordLength == 69) {
                        cd.drawText(360, 400, "" + wordLength);
                        format.setFontSize(30);
                        cd.drawText(360, 500, "Don't try some weird-ass numbers, Mr or Mrs User!");
                        cd.show();
                        format.setFontSize(50);
                    } else {
                        cd.drawText(360, 400, "" + wordLength);
                        cd.drawText(360, 500, "Invalid input!");
                        cd.show();
                    }
                    wordLength = 0;
                } else if (wordLength >= 4 && wordLength <= 10) {
                    cd.setColor(Color.WHITE);
                    cd.fillRectangle(0, 350, 720, 300);
                    cd.show();
                    cd.setColor(Color.BLACK);

                    cd.drawText(360, 400, "" + wordLength);
                    cd.show();
                    correctEnter = true;
                }
            } else {
                cd.setColor(Color.WHITE);
                cd.fillRectangle(0, 350, 720, 300);
                cd.show();
                cd.setColor(Color.BLACK);

                cd.drawText(360, 400, "Not an integer!");
                cd.show();
                scanner.next();
            }
        }











        // while (true) {
            WordList test = new WordList(5,4);
            test.randSelect();
            System.out.println(test.isWord("salt"));


        // }
    }
}
