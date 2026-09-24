package com.mycompany.sudoku;

import java.awt.Point;

/**
* SudokuGrid.
*
* TODO 4: FIll in your names and student IDs:
*
* @author Levi Von Doornik
* @id 2416131
* @author Benjamin Guilhot
* @id 2576740
*/

public class SudokuGrid {
    
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;
    private int[][] grid;
    private int rEmpty;
    private int cEmpty; // Coordinates of the last found empty cell
    
    public SudokuGrid() {
        this.grid = new int[SIZE][SIZE];
        this.rEmpty = -1;
        this.cEmpty = -1;
        // Initialize the grid and set rEmpty and cEmpty to -1
    }
    
    public SudokuGrid copy() {
        SudokuGrid copy = new SudokuGrid();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copy.grid[i][j] = this.grid[i][j];
            }
        }
        copy.rEmpty = this.rEmpty;
        copy.cEmpty = this.cEmpty;
        return copy;
    }
    
    public Point findEmptyCell() {
        Point res = new Point();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 0){
                    res.x = i;
                    res.y = j;
                    return res;
                }
            }
        }
        return null;
    }
    
    public void print() {
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0) {
                System.out.println("+-----------------+");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0){
                    System.out.print("|");
                }
                if ((j+1) % 3 == 0){
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("+-----------------+");
    }
    
    public void fillCell(int r, int c, int d) {
        grid[r][c] = d;
        // Fill the cell at row r and column c
    }
    
    public boolean givesConflict(int r, int c, int d) {
        return rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d);
    }
    
    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d
        return false;
    }
    
    private boolean colConflict(int c, int d) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][c] == d) {
                return true;
            } 
        }
        return false;
    }
    
    private boolean boxConflict(int r, int c, int d) {
        int rowMax;
        int rowMin;
        int colMax;
        int colMin;
        if (r < 3){
            rowMax = 3;
            rowMin = 0;
        } else if (r < 6) {
            rowMax = 6;
            rowMin = 3;
        } else {
            rowMax = 9;
            rowMin = 6;
        }
        if (c < 3){
            colMax = 3;
            colMin = 0;
        } else if (c < 6) {
            colMax = 6;
            colMin = 3;
        } else {
            colMax = 9;
            colMin = 6;
        }
        for (int i = rowMin; i < rowMax; i++){
            for (int j = colMin; j < colMax; j++) {
                if (grid[i][j] == d){
                    return true;
                }
            }
        }
        return false;
    }
    
}
