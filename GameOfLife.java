/**
 * Create a simulation based on Conway's Game Of Life
 *
 * @ Daniel Li
 * @ Java 1.8.0
 */
import java.util.Scanner;

public class GameOfLife {

      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //menu
        System.out.println("Option 1: Block,  Option 2: Blinker, Option 3: Glider" );
        
        System.out.println("Select an option (1, 2, 3): ");
        int option = scan.nextInt();
        System.out.println("Please enter your width: ");
        int x = scan.nextInt();
        System.out.println("Pleaase enter your height: ");
        int y = scan.nextInt();
        System.out.println("Please enter time between ticks (around 300): ");
        int wait = scan.nextInt();
        int accum;
        StdDraw.setXscale(0, x);
        StdDraw.setYscale(0, y);
        StdDraw.enableDoubleBuffering();
        
        boolean[][] currentGrid = new boolean[x][y];
        boolean[][] nextGrid = new boolean[x][y];
        
        if (option == 1) {
            // block
            currentGrid[1][1] = true;
            currentGrid[1][2] = true;
            currentGrid[2][1] = true;
            currentGrid[2][2] = true;
        }
        if (option == 2) {
            // blinker
            currentGrid[2][2] = true;
            currentGrid[2][3] = true;
            currentGrid[2][4] = true;
        }
        if (option == 3) {
            // glider
            currentGrid[1][2] = true;
            currentGrid[2][3] = true;
            currentGrid[3][1] = true;
            currentGrid[3][2] = true;
            currentGrid[3][3] = true;
        }
        
        while (true) {
            nextGrid = new boolean[x][y];
            for (int r = 1; r < x-1; r++) {
                for (int c = 1; c < y-1; c++) {
                    accum = 0;
                    for (int i = -1; i <= 1; i++) { // count LIVE cells
                        for (int j = -1; j <= 1; j++) {
                            if (i == j && i == 0) continue;
                            if (currentGrid[r+i][c+j] == true) {
                                accum++;
                            }
                        }
                    }
                    // follow rules
                    if (currentGrid[r][c] == true) { // check if alive
                        if (accum < 2 || accum > 3) nextGrid[r][c] = false; //  dies
                        else nextGrid[r][c] = true; //  lives
                    }
                    else { // if dead
                        if (accum == 3) nextGrid[r][c] = true; // cell becomes alive
                    }
                }
            }
            
            for (int r = 1; r < x-1; r++) { 
                for (int c = 1; c < y-1; c++) {
                    currentGrid[r][c] = nextGrid[r][c];
                }
            }
            StdDraw.setPenColor(StdDraw.GRAY);
            for (int i = 0; i < x; i++) { // draw the grid 
                StdDraw.line(0,i,x,i);
            }
            for (int i = 0; i < y; i++) { 
                StdDraw.line(i,0,i,y);
            }
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    if (currentGrid[r][c] == true) {
                        StdDraw.filledSquare(r + 0.5, y-c + 0.5, 0.5); // draw the square(s)
                    }
                }
            }
            StdDraw.show();
            StdDraw.pause(wait); // wait 
            StdDraw.clear();
        }
    }

}

