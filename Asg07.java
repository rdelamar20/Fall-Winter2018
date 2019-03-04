/*Ryan Delamar
CIS117 Section 2227
02/01/2019
In this program we use object oriented programming and some light use of the this statement to create a very simple
player attacking player game engine code. Contains a tester in code to see outcome.*/

import java.util.Scanner;
import java.util.Random;




public class Asg07 {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        Player p1 = new Player ("p1", 100);
        Player p2 = new Player ("p2", 100);

        p1.setName();
        p2.setName();


        boolean turn_tracker = true;

        //Attack testing loop until one player loses all health points
        while (p1.getHealth() != 0 || p2.getHealth() != 0){

            if (turn_tracker == true){
                p1.attack(p2);
                turn_tracker = false;
                if (p1.getHealth() == 0) {
                    break;
                }
            }
            else if (turn_tracker == false){
                p2.attack(p1);
                turn_tracker = true;
                if (p2.getHealth() == 0) {
                    break;
                }
            }


        }

    }

    static class Player{

        Scanner input = new Scanner(System.in);

        private String name = "";
        private int health;

        // Constructor for class
        Player(String tag, int hp){

            name = tag;
            health = hp;

        }

        //Assigning name to player object
        public void setName(){

            System.out.println("Please enter a name for this player.");
            String string_input = input.next();
            name = string_input;

        }

        //Retrieving name for player object
        public String getName(){

            return name;

        }

        //Setting health and validating value is >= 0
        public void setHealth(int damage) {

            health = health - damage;

            if (health < 0){

                health = 0;

            }
        }

        //Retrieving health value for player object
        public int getHealth(){

            return health;

        }

        //Attack method for players
        public void attack(Player opponent) {

            //Creating a random number generator for attack rolls
            Random rand = new Random();

            int roll = rand.nextInt(25) + 1;

            //Successful attack roll if statement
            if (roll <= 15){

                opponent.setHealth(roll);
                System.out.println("Player " + this.getName() + " attacked Player " + opponent.getName() + " and the player's health is now " + health);
                if (health == 0) {
                    System.out.println("Player " + opponent.getName() + " has no health points remaining.");
                }

            }

            //Unsuccessful attack roll statement
            else if (roll > 15){

                System.out.println("Player " + this.getName() + " attacked Player " + opponent.getName() + " and missed.");

            }


        }



    }


}
