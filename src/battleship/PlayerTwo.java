package battleship;

public class PlayerTwo extends Game {

    public String name = "Player 2";
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
    public boolean performShooting(Game playerTwo, Game playerOne) {
        boolean gameShouldContinue = true;

        playerOne.printFogGamePlan();
        System.out.println("---------------------");
        playerTwo.printGamePlan();

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

        switch (playerOne.gamePlan[x][Integer.parseInt(number)]) {
            case "O":
            case "X":
                playerOne.gamePlan[x][Integer.parseInt(number)] = "X";
                playerOne.fogPlan[x][Integer.parseInt(number)] = "X";
                if (verifyIfAllShipsSunk(playerOne)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    gameShouldContinue = false;
                    break;
                } else {
                    if (verifyIfShipSunk(x,Integer.parseInt(number),playerOne)) {
                        System.out.println("You sank a ship!");
                    } else {
                        System.out.println("You hit a ship!");
                    }
                    promptEnterKey();
                }
                break;
            case "~":
                playerOne.gamePlan[x][Integer.parseInt(number)] = "M";
                playerOne.fogPlan[x][Integer.parseInt(number)] = "M";
                if (verifyIfAllShipsSunk(playerOne)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    gameShouldContinue = false;
                    break;
                }
                else {
                    System.out.println("You missed!");
                    promptEnterKey();
                }
                break;
        }
        return gameShouldContinue;
    }
}
