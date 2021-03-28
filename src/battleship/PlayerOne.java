package battleship;

public class PlayerOne extends Game {

    public String name = "Player 1";
    public String letter;
    public String number;

    @Override
    public void placeShips() {
        System.out.println(this.name + ", place your ships on the game field");
        printGamePlan();
        buildAircraftCarrier();
        printGamePlan();
        buildBattleship();
        printGamePlan();
        buildSubmarine();
        printGamePlan();
        buildCruiser();
        printGamePlan();
        buildDestroyer();
        printGamePlan();
        promptEnterKey();
    }


    @Override
    public boolean performShooting(Game playerOne, Game playerTwo) {
        boolean gameShouldContinue = true;

        playerTwo.printFogGamePlan();
        System.out.println("---------------------");
        playerOne.printGamePlan();

        System.out.println(this.name + ", it's your turn:");
        String input = scanner.next().trim();
        letter = input.substring(0, 1);
        number = input.substring(1);

        while (!verifyCoordinates(letter, number)) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            input = scanner.next().trim();
            letter = input.substring(0, 1);
            number = input.substring(1);
            verifyCoordinates(letter, number);
        }

        convertLetter(letter);

        switch (playerTwo.gamePlan[x][Integer.parseInt(number)]) {
            case "O":
            case "X":
                playerTwo.gamePlan[x][Integer.parseInt(number)] = "X";
                playerTwo.fogPlan[x][Integer.parseInt(number)] = "X";
                if (verifyIfAllShipsSunk(playerTwo)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    gameShouldContinue = false;
                    break;
                } else {
                    if (verifyIfShipSunk(x,Integer.parseInt(number),playerTwo)) {
                        System.out.println("You sank a ship!");
                    } else {
                        System.out.println("You hit a ship!");
                    }
                    promptEnterKey();
                }
                break;
            case "~":
                playerTwo.gamePlan[x][Integer.parseInt(number)] = "M";
                playerTwo.fogPlan[x][Integer.parseInt(number)] = "M";
                if (verifyIfAllShipsSunk(playerTwo)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    gameShouldContinue = false;
                    break;
                } else {
                    System.out.println("You missed!");
                    promptEnterKey();
                }
                break;
        }
        return gameShouldContinue;
    }

}
