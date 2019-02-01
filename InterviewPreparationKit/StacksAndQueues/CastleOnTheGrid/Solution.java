import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int game[][], helper[][];
    static Queue <Point> move = new LinkedList<Point>();
    static int n;

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        n = grid.length;
        game = new int[n][n];
        helper = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j) == '.')
                    game[i][j] = 100;
                else game[i][j] = -1;
            }
        }

        Point start = new Point(startX, startY);
        move.add(start);
        game[startX][startY] = 0;
        while(!move.isEmpty()){
            Point current = move.remove();
            if(helper[current.x][current.y] == 0){
                helper[current.x][current.y] = 1;
                moveGenerator(current);
            }
        }

        return game[goalX][goalY];

    }

    public static void moveGenerator(Point p){

        int x = p.x;
        int y = p.y;
        int value = game[x][y];
        for(int i=x; i<n && game[i][y]!=-1;i++){
            addStep(i,y,value);
            move.add(new Point(i,y));
        }
        for(int i=x; i>=0 && game[i][y]!=-1;i--){
            addStep(i,y,value);
            move.add(new Point(i,y));
        }
        for(int i=y; i<n && game[x][i]!=-1;i++){
            addStep(x,i,value);
            move.add(new Point(x,i));
        }
        for(int i=y; i>=0 && game[x][i]!=-1;i--){
            addStep(x,i,value);
            move.add(new Point(x,i));
        }
    }

    public static void addStep(int x, int y, int value){
        if(game[x][y] > value+1)
            game[x][y] = value+1;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

