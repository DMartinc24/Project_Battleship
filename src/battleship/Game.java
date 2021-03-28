package battleship;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    String[][] gamePlan = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
    };
    String[][] fogPlan = {
            {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
    };

    List<String> coordinates;
    char letterOne;
    char letterTwo;
    int xOne = 0;
    int xTwo = 0;
    int numberOne = 0;
    int numberTwo = 0;

    Scanner scanner = new Scanner(System.in);

    String[] lettersAndNumbers =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    int x = 0;

    public void printGamePlan() {

        for (String[] strings : gamePlan) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public void printFogGamePlan() {

        for (String[] strings : fogPlan) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public void buildAircraftCarrier() {
        System.out.print("Enter the coordinates of the Aircraft Carrier (5 cells): ");
        giveCoordinates();
        convertCoordinates(letterOne, letterTwo);
        if (runChecks(xOne, xTwo, numberOne, numberTwo, 5)) {
        } else {
            if (!checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Error! Wrong ship location! Try again:");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (!checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 5)) {
                System.out.print("Error! Wrong length of the Aircraft Carrier! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Ship placed too close, Error! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);

            }
        }
        placeShip(xOne, xTwo, numberOne, numberTwo);
    }

    public void buildBattleship() {
        System.out.print("Enter the coordinates of the Battleship (4 cells): ");
        giveCoordinates();
        convertCoordinates(letterOne, letterTwo);
        if (runChecks(xOne, xTwo, numberOne, numberTwo, 4)) {
        } else {
            if (!checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Error! Wrong ship location! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (!checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 4)) {
                System.out.print("Error! Wrong length of the Battleship! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Ship placed too close, Error! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }
        }
        placeShip(xOne, xTwo, numberOne, numberTwo);
    }


    public void buildSubmarine() {
        System.out.print("Enter the coordinates of the Submarine (3 cells): ");
        giveCoordinates();
        convertCoordinates(letterOne, letterTwo);
        if (runChecks(xOne, xTwo, numberOne, numberTwo, 3)) {
        } else {
            if (!checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Error! Wrong ship location! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (!checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 3)) {
                System.out.print("Error! Wrong length of the Submarine! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Ship placed too close, Error! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }
        }
        placeShip(xOne, xTwo, numberOne, numberTwo);
    }

    public void buildDestroyer() {
        System.out.print("Enter the coordinates of the Destroyer (2 cells): ");
        giveCoordinates();
        convertCoordinates(letterOne, letterTwo);
        if (runChecks(xOne, xTwo, numberOne, numberTwo, 2)) {
        } else {
            if (!checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Error! Wrong ship location! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (!checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 2)) {
                System.out.print("Error! Wrong length of the Destroyer! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Ship placed too close, Error! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }
        }
        placeShip(xOne, xTwo, numberOne, numberTwo);
    }


    public void buildCruiser() {
        System.out.print("Enter the coordinates of the Cruiser (3 cells): ");
        giveCoordinates();
        convertCoordinates(letterOne, letterTwo);
        if (runChecks(xOne, xTwo, numberOne, numberTwo, 3)) {
        } else {
            if (!checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Error! Wrong ship location! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (!checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 3)) {
                System.out.print("Error! Wrong length of the Cruiser! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

            if (verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
                System.out.print("Ship placed too close, Error! Try again: ");
                giveCoordinates();
                convertCoordinates(letterOne, letterTwo);
            }

        }
        placeShip(xOne, xTwo, numberOne, numberTwo);

    }


    public boolean checkPlacement(int x, int y, int one, int two) {
        boolean placedRight = true;
        if ((x != y) && (one != two)) placedRight = false;
        return placedRight;
    }


    public void giveCoordinates() {
        String input = scanner.nextLine().trim();
        coordinates = Arrays.asList((input.split(" ")));
        letterOne = coordinates.get(0).charAt(0); //F
        numberOne = Integer.parseInt(coordinates.get(0).substring(1)); //3
        letterTwo = coordinates.get(1).charAt(0); //F
        numberTwo = Integer.parseInt(coordinates.get(1).substring(1));
    }

    public boolean verifyIfPlacedTooClose(int x, int y, int one, int two) {
        boolean placedIncorrectly = false;
        if (x == y && one < two) {
            //example F(x)3(one) F(y)7(two)
            for (int i = (one - 1); i <= (two + 1); i++) {
                try {
                    if (gamePlan[x][i].equals("O") || gamePlan[x - 1][i].equals("O") || gamePlan[x + 1][i].equals("O")) {
                        placedIncorrectly = true;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        if (x == y && one > two) {
            //example F(x)7(one) F(y)3(two)
            for (int i = (two - 1); i <= (one + 1); i++) {
                try {
                    if (gamePlan[x][i].equals("O") || gamePlan[x - 1][i].equals("O") || gamePlan[x + 1][i].equals("O")) {
                        placedIncorrectly = true;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        if (one == two && x < y) {
            //example A(x)1(one) D(y)1(two)
            for (int i = (x - 1); i <= (y + 1); i++) {
                try {
                    if (gamePlan[i][one].equals("O") || gamePlan[i][one - 1].equals("O") || gamePlan[i][one + 1].equals("O")) {
                        placedIncorrectly = true;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        if (one == two && x > y) {
            //example D(x)1(one) A(y)1(two)
            for (int i = (y - 1); i <= (x + 1); i++) {
                try {
                    if (gamePlan[i][one].equals("O") || gamePlan[i][one - 1].equals("O") || gamePlan[i][one + 1].equals("O")) {
                        placedIncorrectly = true;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return placedIncorrectly;
    }

    public boolean checkTheLengthIsCorrect(int x, int y, int one, int two, int cellCount) {
        cellCount = cellCount - 1;
        boolean lengthIsCorrect = false;
        if (x == y) {
            if (one - two == cellCount || two - one == cellCount) {
                lengthIsCorrect = true;
            }
        }
        if (one == two) {
            if (x - y == cellCount || y - x == cellCount) {
                lengthIsCorrect = true;
            }
        }
        return lengthIsCorrect;
    }

    public void convertCoordinates(char letterOne, char letterTwo) {
        if (letterOne == 'A') {
            xOne = 1;
        } else if (letterOne == 'B') {
            xOne = 2;
        } else if (letterOne == 'C') {
            xOne = 3;
        } else if (letterOne == 'D') {
            xOne = 4;
        } else if (letterOne == 'E') {
            xOne = 5;
        } else if (letterOne == 'F') {
            xOne = 6;
        } else if (letterOne == 'G') {
            xOne = 7;
        } else if (letterOne == 'H') {
            xOne = 8;
        } else if (letterOne == 'I') {
            xOne = 9;
        } else if (letterOne == 'J') {
            xOne = 10;
        }

        if (letterTwo == 'A') {
            xTwo = 1;
        } else if (letterTwo == 'B') {
            xTwo = 2;
        } else if (letterTwo == 'C') {
            xTwo = 3;
        } else if (letterTwo == 'D') {
            xTwo = 4;
        } else if (letterTwo == 'E') {
            xTwo = 5;
        } else if (letterTwo == 'F') {
            xTwo = 6;
        } else if (letterTwo == 'G') {
            xTwo = 7;
        } else if (letterTwo == 'H') {
            xTwo = 8;
        } else if (letterTwo == 'I') {
            xTwo = 9;
        } else if (letterTwo == 'J') {
            xTwo = 10;
        }
    }

    public void placeShip(int x, int y, int one, int two) {
        if (x == y && one < two) {
            //example F(x)3(one) F(y)7(two)
            for (int i = one; i <= two; i++) {
                gamePlan[x][i] = "O";
            }
        }
        if (x == y && one > two) {
            //example F(x)7(one) F(y)3(two)
            for (int i = two; i <= one; i++) {
                gamePlan[x][i] = "O";
            }
        }
        if (one == two && x < y) {
            //example A(x)1(one) D(y)1(two)
            for (int i = x; i <= y; i++) {
                gamePlan[i][one] = "O";
            }
        }
        if (one == two && x > y) {
            //example D(x)1(one) A(y)1(two)
            for (int i = y; i <= x; i++) {
                gamePlan[i][one] = "O";
            }
        }
    }

    public boolean runChecks(int x, int y, int one, int two, int cellCount) {
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        boolean finalResult = false;

        if (checkPlacement(xOne, xTwo, numberOne, numberTwo)) {
            result1 = true;
        }

        if (checkTheLengthIsCorrect(xOne, xTwo, numberOne, numberTwo, 3)) {
            result2 = true;
        }

        if (!verifyIfPlacedTooClose(xOne, xTwo, numberOne, numberTwo)) {
            result3 = true;
        }

        if (result1 && result2 && result3) {
            finalResult = true;
        }
        return finalResult;
    }

    public boolean performShooting(Game playerOne, Game playerTwo) {
        return true;
    }

    public void convertLetter(String letterOne) {
        switch (letterOne) {
            case "A":
                x = 1;
                break;
            case "B":
                x = 2;
                break;
            case "C":
                x = 3;
                break;
            case "D":
                x = 4;
                break;
            case "E":
                x = 5;
                break;
            case "F":
                x = 6;
                break;
            case "G":
                x = 7;
                break;
            case "H":
                x = 8;
                break;
            case "I":
                x = 9;
                break;
            case "J":
                x = 10;
                break;
        }
    }

    public boolean verifyCoordinates(String letter, String number) {
        boolean correct = true;
        boolean goodLetterCoordinate = false;
        boolean goodNumberCoordinate = false;

        for (String lettersAndNumber : lettersAndNumbers) {
            if (letter.equals(lettersAndNumber)) {
                goodLetterCoordinate = true;
            }
            if (number.equals(lettersAndNumber)) {
                goodNumberCoordinate = true;
            }
        }

        if (!goodLetterCoordinate || !goodNumberCoordinate) {
            correct = false;
        }
        return correct;
    }


    public boolean verifyIfAllShipsSunk(Game game) {
        boolean result = true;
        for (String[] strings : game.gamePlan) {
            for (String string : strings) {
                if (string.equals("O")) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void placeShips() {
    }

    public boolean verifyIfShipSunk(int x, int y, Game player) {
        boolean shipSunk = true;
        //example B2, need to check B1, A2, B3, C2
        try {
            if (player.gamePlan[x][y - 1].equals("O") || player.gamePlan[x][y + 1].equals("O") || player.gamePlan[x + 1][y].equals("O") || player.gamePlan[x - 1][y].equals("O")) {
                shipSunk = false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return shipSunk;
    }
}





