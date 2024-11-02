package com.example.mazesolver;


public class main {
    public static void main(String[] args) {
        int width = 21;
        int height = 21;

        // Generate the maze
        MazeGenerator generator = new MazeGenerator(width, height);
        System.out.println("Generated Maze:");
        generator.displayMaze();

        // Solve the maze
        MazeSolver solver = new MazeSolver(generator.getMaze());
        if (solver.solveMaze(1, 1)) { // Start solving from (1,1), the start point 'S'
            System.out.println("\nSolved Maze:");
            generator.displayMaze();
        } else {
            System.out.println("No solution found.");
        }
    }
}
