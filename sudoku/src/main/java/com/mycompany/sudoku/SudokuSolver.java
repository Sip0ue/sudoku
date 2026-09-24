package com.mycompany.sudoku;

/**
* SudokuSolver.
*
* TODO 4: FIll in your names and student IDs:
*
* @author Levi von Doornik
* @id 2416131
* @author Benjamin Guilhot
* @id 2576740
*/

public class SudokuSolver {
    
    SudokuGrid grid;
    
    public SudokuSolver(SudokuGrid grid) {
        this.grid = grid;
        // Initialize the SudokuSolver with the provided SudokuGrid
    }
    
    public boolean solve() {
        // Use a recursive strategy to solve the Sudoku puzzle
        var p = grid.findEmptyCell();
        if (p == null) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (!grid.givesConflict(p.x, p.y, i)) {
                grid.fillCell(p.x, p.y, i);
                if (solve()) {
                    return true;
                }
            }
            grid.fillCell(p.x, p.y, 0);
        }
        return false;
    }
    
    public void solveIt() {
        if (solve()) {
            grid.print();
        } else {
            System.out.println("No solution");
        }
    }
    
    public static void main(String[] args) {
        SudokuGrid grid = new SudokuGrid();
        SudokuSolver solver = new SudokuSolver(grid);
    }
    
}
