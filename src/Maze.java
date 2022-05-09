//Instructions:
// First step: Choose your starting point changing the y (Column) and x (Row). The corresponding line is marked with "***THIS LINE***"
// second step: Run the program
//Tags:
// 0 = Wall
// 1 = Path
// 2 = Destination
// 5 = Maze limits

import java.util.LinkedList;
class Maze {
    static int[][] maze = {
        //   0  1  2  3  4  5  6  7  8
            {5, 5, 5, 5, 5, 5, 5, 5, 5},//0
            {5, 2, 1, 1, 1, 0, 0, 0, 5},//1
            {5, 0, 0, 0, 1, 0, 0, 0, 5},//2
            {5, 0, 0, 0, 1, 0, 0, 0, 5},//3
            {5, 0, 1, 1, 1, 0, 0, 0, 5},//4
            {5, 0, 0, 0, 1, 0, 0, 0, 5},//5
            {5, 0, 0, 0, 1, 0, 0, 0, 5},//6
            {5, 0, 0, 0, 1, 1, 1, 0, 5},//7
            {5, 5, 5, 5, 5, 5, 5, 5, 5} //8
    };
    static LinkedList<Position> stack = new LinkedList<Position>();

    public static void main(String[] args) {
        Position p = new Position(7, 6); //***THIS LINE***
        stack.push(p);

        while (true) {
            int y = stack.peek().y;
            int x = stack.peek().x;
            maze[y][x] = 0;

            //Go Down
            if(mazeLimits(y+1, x)) {
                if (maze[y+1][x] == 2) {
                    System.out.println("Congrats! You Successfully escaped from the maze, But i'm sorry...The princess is in another maze!");
                    return;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("Moved to Down");
                    stack.push(new Position(y+1, x));
                    continue;
                }
            }

            //Go Up
            if(mazeLimits(y-1, x)) {
                if (maze[y-1][x] == 2) {
                    System.out.println("Congrats! You Successfully escaped from the maze, But i'm sorry...The princess is in another maze!");
                    return;
                } else if (maze[y-1][x] == 1) {
                    System.out.println("Moved to Up");
                    stack.push(new Position(y-1, x));
                    continue;
                }
            }

            //Go Right
            if(mazeLimits(y, x+1)) {
                if (maze[y][x+1] == 2) {
                    System.out.println("Congrats! You Successfully escaped from the maze, But i'm sorry...The princess is in another maze!");
                    return;
                } else if (maze[y][x+1] == 1) {
                    System.out.println("Moved to Right");
                    stack.push(new Position(y, x+1));
                    continue;
                }
            }

            //Go Left
            if(mazeLimits(y, x-1)) {if (maze[y][x-1] == 2) {
                    System.out.println("Congrats! You Successfully escaped from the maze, But i'm sorry...The princess is in another maze!");
                    return;
                } else if (maze[y][x-1] == 1) {
                    System.out.println("Moved to Left");
                    stack.push(new Position(y, x-1));
                    continue;
                }
            }

            stack.pop();
            System.out.println("Moved back, there was no way out!");
            if (stack.size() <=0) {
                System.out.println("There is no way out ;-;");
                return;
            }
        }
    }
    public static boolean mazeLimits(int y, int x) {
        if(y < 0 ||y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;

    }

}
