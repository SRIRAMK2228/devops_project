package com.example.mazesolver;

import java.util.Random;

public class MazeGenerator {
    private int width;
    private int height;
    private char[][] maze;
    private Random random = new Random();

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new char[height][width];
        generateMaze();
    }

    private void generateMaze() {
        // Fill the maze with walls
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = '#';
            }
        }

        // Start carving from the top-left corner (1,1)
        carvePath(1, 1);

        // Mark start and end points
        maze[1][1] = 'S'; // Start
        maze[height - 2][width - 2] = 'E'; // End
    }

    private void carvePath(int x, int y) {
        // Directions: right, down, left, up
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        // Randomize directions
        for (int i = 0; i < directions.length; i++) {
            int j = random.nextInt(directions.length);
            int[] temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }

        // Try each direction
        for (int[] direction : directions) {
            int dx = x + direction[0] * 2;
            int dy = y + direction[1] * 2;

            if (dx > 0 && dx < width - 1 && dy > 0 && dy < height - 1 && maze[dy][dx] == '#') {
                maze[dy - direction[1]][dx - direction[0]] = ' ';
                maze[dy][dx] = ' ';
                carvePath(dx, dy);
            }
        }
    }

    public char[][] getMaze() {
        return maze;
    }

    public void displayMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
