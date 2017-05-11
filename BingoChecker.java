package bingochecker;

import java.util.Scanner;

public class BingoChecker {
    
    //  Bingo Checker - this program takes coordinate inputs from the user
    //      to fill an imaginary bingo card. These coordinates are saved in 
    //      a 2D array, and informs the user when a continous vertical, 
    //      horizontal, or diagonal line occures.
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        bingoCard myCard = new bingoCard();
        boolean bingo=false;
        System.out.println("Welcome to bingo checker.  Input a a coordinate from 1,1 to 100,100: ");
        //  As long as a bingo is not present, more inputs will be asked for.
        while(!bingo) {
            String coordinateInput = keyboard.nextLine();
            //  Checks if the keyboard input matches two numbers between 1 and 100
            //      seperated by a comma.
            if(coordinateInput.matches("(100|([1-9][0-9])|[1-9]),(100|([1-9][0-9])|[1-9])")) {
                //  Splits the input into an X and Y coordinate and casts them
                //      to integers.  1 is subtracted from each value to compensate
                //      for the 0 index.
                String [] inputArray = coordinateInput.split(",");
                int xCoordinate = Integer.valueOf(inputArray[0])-1;
                int yCoordinate = Integer.valueOf(inputArray[1])-1;
                //  Pass the coordinates to the bingo card, and if a bingo is created, 
                //      the loop ends.
                if(myCard.coordinateInput(xCoordinate,yCoordinate)) {
                    bingo = true;
                }
            }
            else {
                System.out.println("incorrectly formated input.  Please try again.");
            }
        }
        System.out.println("Bingo!");
    }
    
}
