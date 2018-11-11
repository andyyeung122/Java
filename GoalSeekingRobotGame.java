import java.util.ArrayList;
import java.util.Scanner;

public class GoalSeekingRobotGame {
    private static void output(char x[][], int a, int b) {
        if (b - 2 < 0) {
            for (int i = a - 2; i < a + 3; i++) {
                for (int j = 0; j < b + 3; j++) {
                    System.out.print(x[i][j]);
                }
                System.out.println();
            }
        }
        else {
            for (int i = a - 2; i < a + 3; i++) {
                for (int j = b - 2; j < b + 3; j++) {
                    System.out.print(x[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "game.txt";
        Scanner loader = new Scanner(GoalSeekingRobotGame.class.getResourceAsStream(fileName));
        int numSteps = loader.nextInt();
        int y = loader.nextInt();
        int x = loader.nextInt();
        loader.nextLine();
        ArrayList<char[]> land = new ArrayList<>();
        while (loader.hasNext()){
            String nextLine = loader.nextLine();
            char[] nextRow = new char[nextLine.length()];
            for (int i = 0; i < nextLine.length(); i++) {
                nextRow[i] = nextLine.charAt(i);
            }

            land.add(nextRow);
        }

        char[][] inputMap = new char[land.size()][];
        for (int i = 0; i < inputMap.length; i++) {
            inputMap[i] = land.get(i);
        }
        // start of code
        Scanner input = new Scanner(System.in);


        inputMap[y][x] = 'o';
        System.out.println(numSteps);

        for (char[] elements : inputMap){
            System.out.println(elements);
        }
        output(inputMap, y, x);

        //user input
        char dir;
        boolean z = false;
        do{
            dir = input.nextLine().charAt(0);
            switch(dir) {
                case 'u':
                    if (inputMap[y-1][x] == '#' || inputMap[y-1][x] == '%'){
                        System.out.println("Out of bounds");
                        output(inputMap, y, x);
                        break;
                    }
                    if (inputMap[y-1][x] == '-') {
                        numSteps = numSteps - 10;
                    }
                    if (inputMap[y-1][x] == '+') {
                        numSteps = numSteps + 10;
                    }
                    numSteps --;
                    System.out.println(numSteps);
                    if (numSteps == 0) {
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("You are a loser");
                        z = true;
                        break;
                    }
                    if (inputMap[y-1][x] == '*'){
                        inputMap[y][x] = '.';
                        inputMap[y-1][x] = 'o';
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("Congratulations! You won the game!");
                        z = false;
                        break;
                    }
                    inputMap[y][x] = '.';
                    inputMap[y-1][x] = 'o';
                    y = y-1;
                    output(inputMap, y, x);
                    System.out.println();
                    z = false;
                    break;

                case 'r':
                    if (inputMap[y][x+1] == '#' || inputMap[y][x+1] == '%'){
                    System.out.println("Out of bounds");
                    output(inputMap, y, x);
                    break;
                    }
                    if (inputMap[y][x+1] == '-') {
                        numSteps = numSteps - 10;
                    }
                    if (inputMap[y][x+1] == '+') {
                        numSteps = numSteps + 10;
                    }
                    numSteps --;
                    System.out.println(numSteps);
                    if (numSteps == 0) {
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("You are a loser");
                        z = false;
                        break;
                    }
                    if (inputMap[y][x+1] == '*'){
                        inputMap[y][x] = '.';
                        inputMap[y][x+1] = 'o';
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("Congratulations! You won the game!");
                        z = false;
                        break;
                    }
                    inputMap[y][x] = '.';
                    inputMap[y][x+1] = 'o';
                    x = x +1;
                    output(inputMap, y, x);
                    System.out.println();
                    z = false;
                    break;

                case 'd':
                    if (inputMap[y+1][x] == '#' || inputMap[y+1][x] == '%'){
                        System.out.println("Out of bounds");
                        output(inputMap, y, x);
                        break;
                    }
                    if (inputMap[y+1][x] == '-') {
                        numSteps = numSteps - 10;
                    }
                    if (inputMap[y+1][x] == '+') {
                        numSteps = numSteps + 10;
                    }
                    numSteps --;
                    System.out.println(numSteps);
                    if (numSteps == 0) {
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("You are a loser");
                        z = false;
                        break;
                    }
                    if (inputMap[y+1][x] == '*'){
                        inputMap[y][x] = '.';
                        inputMap[y+1][x] = 'o';
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("Congratulations! You won the game!");
                        z = false;
                        break;
                    }
                    inputMap[y][x] = '.';
                    inputMap[y+1][x] = 'o';
                    y = y+1;
                    try {
                        output(inputMap, y, x);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Warning: ArrayIndexOutOfBoundsException");
                    }
                    System.out.println();
                    z = false;
                    break;

                case 'l':
                    if (inputMap[y][x-1] == '#' || inputMap[y][x-1] == '%'){
                        System.out.println("Out of bounds");
                        output(inputMap, y, x);
                        break;
                    }
                    if (inputMap[y][x-1] == '-') {
                        numSteps = numSteps - 10;
                    }
                    if (inputMap[y][x-1] == '+') {
                        numSteps = numSteps + 10;
                    }
                    numSteps --;
                    System.out.println(numSteps);
                    if (numSteps == 0) {
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("You are a loser");
                        z = false;
                        break;
                    }
                    if (inputMap[y][x-1] == '*'){
                        inputMap[y][x] = '.';
                        inputMap[y][x-1] = 'o';
                        for (char[] elements : inputMap) {
                            System.out.println(elements);
                        }
                        System.out.println("Congratulations! You won the game!");
                        z = false;
                        break;
                    }
                    inputMap[y][x] = '.';
                    inputMap[y][x-1] = 'o';
                    x = x-1;
                    output(inputMap, y, x);
                    System.out.println();
                    z = false;
                    break;

                case ' ':
                    return;

            }
        }while (!z);
    }
}
