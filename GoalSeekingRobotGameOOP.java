import java.util.ArrayList;
import java.util.Scanner;

public class GoalSeekingRobotGameOOP {
    public static class Robot {
        private int Steps, xvalue,yvalue, y2, x2, y3;
        private char Map[][];
        private Robot(char Map[][], int Steps, int xvalue, int yvalue, int y2, int x2, int y3){
            this.Map = Map; this.Steps = Steps; this.xvalue = xvalue; this.yvalue = yvalue; this.y2 =y2; this.x2=x2; this.y3=y3;}
        private char[][] getMap() {
            return this.Map;
        }
        private int getSteps() {
            return this.Steps;
        }
        private int getxvalue() {
            return xvalue;
        }
        private int getyvalue() {
            return yvalue;
        }
        private int getA(){return y2;}
        private int getB(){return x2;}
        private char[][] printMap(char[][] a) {
            for (char[] elements : a) {
                System.out.println(elements);
            } return null; }
        private void output(char x[][], char c, int a, int b) {
            if (c == 'l') {
                if (y3 < yvalue){y3 = yvalue;}
                for (int i = y2-2; i < yvalue + 3; i++) {
                    for (int j = 0; j < b + 4; j++) {
                        System.out.print(x[i][j]); }
                        System.out.println(); } }
            else if (c == 'u'){
                if (y3 < yvalue){y3 = yvalue;}
                if (yvalue < 9){y2--;}
                for (int i = y2-2; i < y3+ 3; i++) {
                    for (int j = 0; j < b + 4; j++) {
                        System.out.print(x[i][j]); }
                        System.out.println(); } }
             else if (c == 'd'){
                if (y3 < yvalue){y3 = yvalue;}
                for (int i = y2-2; i < y3 + 3; i++) {
                    for (int j = 0; j < b + 4; j++) {
                        System.out.print(x[i][j]); }
                    System.out.println();}}
             else if (c == 'r'){
                if (y3 < yvalue){y3 = yvalue;}
                 x2++;
                for (int i = y2-2; i < y3 + 3; i++) {
                    for (int j = 0; j < b + 4; j++) {
                        System.out.print(x[i][j]); }
                    System.out.println(); } }
            else {
                for (int i = a-2; i < a + 3; i++) {
                    for (int j = 0; j < x2 + 3; j++) {
                        System.out.print(x[i][j]); }
                    System.out.println(); } }
        }
        private Boolean Bounds(char Map[][], int n, int m) {
            if (Map[yvalue + n][xvalue + m] == '#' || Map[yvalue + n][xvalue + m] == '%'){
                System.out.println("Out of Bounds");
                return true; }
                return false;
        }
        private void BT(char Map[][], int n, int m) {
            if (Map[yvalue + n][xvalue + m] == '-') {
                Steps = Steps - 10;
            }
            if (Map[yvalue + n][xvalue + m] == '+') {
                Steps = Steps + 10;
            }
        }
        private void Down() {
            Steps = Steps - 1;
        }
        private void setrobot() {
            Map[yvalue][xvalue] = 'o';
        }
        private String lose() {
            if (Steps == 0) {
                for (char[] elements : this.Map) { System.out.println(elements); }
                System.out.println("You are a loser"); }
            return "You are a loser";
        }
        private String win(char Map[][], int n, int m) {
            if (Map[yvalue + n][xvalue + m] == '*') {
                Map[yvalue][xvalue] = '.';
                Map[yvalue + n][xvalue + m] = 'o';
                for (char[] elements : this.Map) {
                    System.out.println(elements); }
                System.out.println("Congratulations! You won the game!"); }
            return ("Congratulations! You won the game!");
        }
        private void move(char Map[][], int n, int m) {
            if (Map[yvalue + n][xvalue + m] == 'd' || Map[yvalue + n][xvalue + m] == 'u' || Map[yvalue + n][xvalue + m] == 'l' || Map[yvalue + n][xvalue + m] == 'r'){
                char o = Map[yvalue + n][xvalue + m];
                Map[yvalue][xvalue] = '.';
                Map[yvalue + n][xvalue + m] = o; }
            else if(Map[yvalue][xvalue] == 'd' || Map[yvalue][xvalue] == 'u' || Map[yvalue][xvalue] == 'l' || Map[yvalue][xvalue] == 'r') {
                char p = Map[yvalue][xvalue];
                Map[yvalue][xvalue] = p;
                Map[yvalue + n][xvalue + m] = 'o'; }
            else{
            Map[yvalue][xvalue] = '.';
            Map[yvalue + n][xvalue + m] = 'o';}
            xvalue = xvalue + m;
            yvalue = yvalue + n;
            System.out.println();
        }
        public static void main(String[] args) {
            String fileName = "game.txt";
            Scanner loader = new Scanner(GoalSeekingRobotGameOOP.class.getResourceAsStream(fileName));
            int numSteps = loader.nextInt();
            int y = loader.nextInt();
            int x = loader.nextInt();
            loader.nextLine();
            ArrayList<char[]> land = new ArrayList<>();
            while (loader.hasNext()) {
                String nextLine = loader.nextLine();
                char[] nextRow = new char[nextLine.length()];
                for (int i = 0; i < nextLine.length(); i++) {
                    nextRow[i] = nextLine.charAt(i);
                } land.add(nextRow);
            }
            char[][] inputMap = new char[land.size()][];
            for (int i = 0; i < inputMap.length; i++) {
                inputMap[i] = land.get(i);
            }
            // start of code
            Robot robot = new Robot(inputMap, numSteps, x, y, y, x, y);
            Scanner input = new Scanner(System.in);
            robot.setrobot();

            System.out.println(robot.getSteps());
            robot.printMap(inputMap);
            robot.output(inputMap,'a', robot.getyvalue(), robot.getxvalue());
            do{
                char dir = input.nextLine().charAt(0);
                if (dir == 'u') {
                    if (robot.Bounds(robot.getMap(), -1, 0)){
                        continue;}
                    robot.BT(robot.getMap(), -1, 0);
                    robot.move(robot.getMap(), -1, 0);
                    robot.win(robot.getMap(), -1, 0);
                    robot.output(robot.getMap(),'u',robot.getA(), robot.getB());
                }
                else if (dir == 'r') {
                    if (robot.Bounds(robot.getMap(), 0, 1)){
                        continue;}
                    robot.BT(robot.getMap(), 0, 1);
                    robot.move(robot.getMap(), 0, 1);
                    robot.win(robot.getMap(), 0, 1);
                    robot.output(robot.getMap(),'r',robot.getA(), robot.getB());
                }
                else if (dir == 'd') {
                    if (robot.Bounds(robot.getMap(), 1, 0)){
                        continue;}
                    robot.BT(robot.getMap(), 1, 0);
                    robot.move(robot.getMap(), 1, 0);
                    robot.win(robot.getMap(), 1, 0);
                    robot.output(robot.getMap(),'d',robot.getA(), robot.getB());
                }
                else if (dir == 'l'){
                    if(robot.Bounds(robot.getMap(), 0, -1)){
                        continue;}
                    robot.BT(robot.getMap(), 0, -1);
                    robot.move(robot.getMap(), 0, -1);
                    robot.win(robot.getMap(), 0, -1);
                    robot.output(robot.getMap(),'l',robot.getA(), robot.getB());
                }
                else if(dir == ' '){
                    break;}
                robot.Down();
                System.out.println(robot.getSteps());
                robot.lose();
            } while (input.hasNextLine());
        }
    }
}