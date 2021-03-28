package battleship;

public class Main {
    public static void main(String[] args) {
        Game playerOne = new PlayerOne();
        Game playerTwo = new PlayerTwo();
        playerOne.placeShips();
        playerTwo.placeShips();
        while (playerOne.performShooting(playerOne, playerTwo) && playerTwo.performShooting(playerTwo,playerOne)) {
            playerOne.performShooting(playerOne, playerTwo);
            playerTwo.performShooting(playerTwo, playerOne);
        }
    }

}



