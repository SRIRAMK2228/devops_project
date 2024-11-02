package com.example.mazesolver;

public class MazeSolver {
	private char[][] maze;
    private boolean[][] visited;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean solveMaze(int x, int y) {
        // Check if out of bounds or already visited or hit a wall
        if (x < 0 || y < 0 || x >= maze[0].length || y >= maze.length || maze[y][x] == '#' || visited[y][x]) {
            return false;
        }

        // Check if we found the end
        if (maze[y][x] == 'E') {
            return true;
        }

        // Mark the current cell as visited
        visited[y][x] = true;

        // Try moving in all four directions: right, down, left, up
        if (solveMaze(x + 1, y) || solveMaze(x, y + 1) || solveMaze(x - 1, y) || solveMaze(x, y - 1)) {
            maze[y][x] = '.'; // Part of the solution path
            return true;
        }

        return false; // No path found from this cell
    }

}
