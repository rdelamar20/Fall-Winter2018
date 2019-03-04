/*Ryan Delamar
CIS117 Section 2227
02/01/2019
In this program I have created a simple dice rolling game that will show my understanding of
if, else if, and else structures in order to alter a programs direction according to input
and creation of random values. I also display some use of a couple of while loops to check
for a winner and for valid input from a user.*/

import java.util.Random;
import java.util.Scanner;

public class Asg_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean winner = false;
        boolean player_turn = true;
        boolean roll_again = false;
        int player_score = 0;
        int comp_score = 0;
        int answer = 0;
        Random rand = new Random();
        int die_1 = 0;
        int die_2 = 0;
        double comp_thing = 0;

        while (!winner) {
            //Player turn structure
            if (player_turn) {
                System.out.println("Your Turn!");

                //Generating Random number for dice
                die_1 = rand.nextInt(6) + 1;
                die_2 = rand.nextInt(6) + 1;
                System.out.printf("You rolled: %d and %d. \n", die_1, die_2);

                //Checking Dice value structure
                if (die_1 != 1 && die_2 != 1) {

                    player_score += die_1 + die_2;
                    answer = 0;
                    System.out.printf("Your score is now %d. \n", player_score);

                    //Checking if Player wins
                    if (player_score >= 100) {
                        System.out.println("You Win!");
                        winner = true;
                        break;
                    }

                    //Checking if player wants to roll again. Also checking valid input.
                    while (answer != 1 && answer != 2) {
                        System.out.println("Would you like to roll again (enter 1) or pass your turn (enter 2)?");
                        answer = input.nextInt();
                        if (answer == 1) {
                            player_turn = true;
                        } else if (answer == 2) {
                            player_turn = false;
                        } else {
                            System.out.println("Please enter a valid option!");
                        }
                    }

                } else if (die_1 == 1 || die_2 == 1) {

                    if (player_turn) {
                        player_turn = false;
                        System.out.println("You lose your turn!");
                    }

                } else {
                    player_score = 0;
                    player_turn = false;
                    System.out.println("Bummer! You lost all your points!");
                }

            }//Computer turn structure
            else {

                System.out.println("Computer's Turn!");
                die_1 = rand.nextInt(6) + 1;
                die_2 = rand.nextInt(6) + 1;
                System.out.printf("Computer rolled: %d and %d. \n", die_1, die_2);

                if (die_1 != 1 && die_2 != 1) {

                    comp_score += die_1 + die_2;
                    System.out.printf("Computer score is now %d. \n", comp_score);

                    //Checking if computer wins
                    if (comp_score >= 100) {
                        System.out.println("Computer wins!");
                        winner = true;
                        break;
                    }

                    //Checking if Computer wants to roll again.
                    comp_thing = Math.random();
                    if (comp_thing > 0.5) {
                        player_turn = false;
                    } else {
                        player_turn = true;
                        System.out.println("Computer passes its turn!");
                    }

                } else if (die_1 == 1 || die_2 == 1) {

                    if (!player_turn) {
                        player_turn = true;
                        System.out.println("Computer loses its turn!");
                    }

                } else {
                    comp_score = 0;
                    player_turn = true;
                    System.out.println("Bummer! Computer lost all its points!");
                }

            }


        }
    }

}