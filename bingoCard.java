package bingochecker;

    //  Bingo Card - This class emulates a 100-100 bingo card.
public class bingoCard {
    
    //  Checked boxes - Integer, tracks how many unique inputs have been recieved.
    //  cardCoordinates - 2D boolean array, emulates a 100 by 100 sized bingo card. 
    public int checkedBoxes = 0;
    public boolean [][] cardCoordinates = new boolean [100][100];
    
    //  Given an x and y coordinate, if the values have already been recieved,
    //      inform the user to input a new coordinate.  Otherwise, set the given
    //      address in the array to true.  If there have been 100 unique inputs
    //      (the minimum required to create a bingo) check if one exists using
    //      the newly changed value.  If so, return true.
    public boolean coordinateInput (int xCoordinate,int yCoordinate) {
        if(cardCoordinates[xCoordinate][yCoordinate]==true)
        {
            System.out.println("That's already been input.  Try another coordinate.");
        }
        else {
            cardCoordinates[xCoordinate][yCoordinate]=true;
            checkedBoxes++;
            if(checkedBoxes>99 && checkForBingo(xCoordinate,yCoordinate)) {
                return true;
            }
        }
        return false;
    }
    
    //  Given the x and y coordinate of the newly changed address.  Check
    //      to see if a horizontal or vertical bingo is possible, or if it
    //      lies on one of the diagonals, one of them exists.  If so, return
    //      true.
    public boolean checkForBingo(int xCoordinate, int yCoordinate) {
        verticalCheck:
        for(int y=0; y<=50; y++) {
            if(cardCoordinates[xCoordinate][y]!=true || cardCoordinates[xCoordinate][99-y]!=true)
                break verticalCheck;
            if(y==50)
                return true;
        }
        horizontalCheck:
        for(int x=0; x<=50; x++) {
            if(cardCoordinates[x][yCoordinate]!=true || cardCoordinates[99-x][yCoordinate]!=true)
                break horizontalCheck;
            if(x==50)
                return true;
        }
        topLeftbottomRightDiagonalCheck:
        if(xCoordinate==yCoordinate) {
            for(int z=0; z<=50; z++) {
                if(cardCoordinates[z][z]!=true || cardCoordinates[99-z][99-z]!=true)
                    break topLeftbottomRightDiagonalCheck;
                if(z==50) {
                    return true;
                }
            }
        }
        topRightbottomLeftDiagonalCheck:
        if(xCoordinate+yCoordinate==99) {
            for(int q=0; q<=50; q++) {
                if(cardCoordinates[q][99-q]!=true || cardCoordinates[99-q][q]!=true) {
                    break topRightbottomLeftDiagonalCheck;
                }
                if(q==50) {
                    return true;
                }
            }
        }
        return false;
    }
}
