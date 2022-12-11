import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Second_of_December {
    /* Values for hands and states of the game, given by the elves*/
    static final int rock = 1;
    static final int paper = 2;
    static final int scissors = 3;

    static final int loss = 0;
    static final int draw = 3;
    static final int win = 6;

    public static void main(String[] args) throws Exception {
        /*Defining the play strategies for player and opponent*/

        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("A", rock);
        shapes.put("B", paper);
        shapes.put("C", scissors);
        shapes.put("X", rock);
        shapes.put("Y", paper);
        shapes.put("Z", scissors);

        //Testdata from the problem

        /* String testdata = """
            A Y
            B X
            C Z
                """; */

        BufferedReader br = new BufferedReader(new FileReader("Input_Files/Second_of_December.txt"));

        /* Initialising the score variable for part 1 and part 2 of the problem */
        int score = 0;

        int predscore = 0;

        String line;

        /* Reading the given Input_File line by line and splitting for the given hand of the player */
        while ((line = br.readLine()) != null) {
            String[] match = line.trim().split(" ");

            /* The elves are going to play more than 2 matches */
            if(match.length != 2) continue;

            /* If-statements for all the outcomes and points aka score */
            if (shapes.get(match[0]) == shapes.get(match[1])){
                score += draw;
            } else if(
                shapes.get(match[0]) == rock &&
                shapes.get(match[1]) == paper
            ){
                score += win;
            } else if (
                shapes.get(match[0]) == paper &&
                shapes.get(match[1]) == scissors
            ){
                score += win;
            }else if (
                shapes.get(match[0]) == scissors &&
                shapes.get(match[1]) == rock
            ){
                score += win;
            }else {
                score += loss;
            }

            score += shapes.get(match[1]);

            /* If-statements for all the outcomes in part 2*/
            if (match[1].equals("X")) {
                predscore += loss;

                if (shapes.get(match[0]) == rock) {
                    predscore += scissors;
                }
                if (shapes.get(match[0]) == paper) {
                    predscore += rock;
                }
                if (shapes.get(match[0]) == scissors) {
                    predscore += paper;
                }
            }
            if (match[1].equals("Y")){
                predscore += draw;
                predscore += shapes.get(match[0]);
            }
            if (match[1].equals("Z")){
                predscore += win;

                if (shapes.get(match[0]) == rock) {
                    predscore += paper;
                }
                if (shapes.get(match[0]) == paper) {
                    predscore += scissors;
                }
                if (shapes.get(match[0]) == scissors) {
                    predscore += rock;
                }
            }

        }

        /* Printing the scores in the console to transfer them to the AoC-Website */
        System.out.println(score);
        System.out.println(predscore);

        br.close(); 
    }



}
