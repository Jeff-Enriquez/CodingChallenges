/*
 * https://leetcode.com/problems/game-of-life/description/
 * 
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 *      k = total number of elements within board
 */
public class GameOfLife {
    // Only use if current state is changed from alive to dead
    final int nextStateDead = 2;
    // Only use if current state is changed from dead to alive
    final int nextStateAlive = 3;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                int aliveCount = countLiveNeighbors(board, row, column);
                board[row][column] = nextState(board[row][column], aliveCount);
            }
        }
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                board[row][column] = finalState(board[row][column]);
            }
        }
    }
    
    // Counts all of the neighbors of the given cell
    int countLiveNeighbors(int[][]board, int row, int column) {
        // Subtract the current cell
        int aliveCount = -isAlive(board[row][column]);
        // Loop through all cells surrounding current cell (including current cell)
        for(int r = Math.max(row - 1, 0); r <= Math.min(row + 1, board.length - 1); r++) {
            for(int c = Math.max(column - 1, 0); c <= Math.min(column + 1, board[0].length - 1); c++) {
                aliveCount += isAlive(board[r][c]);
            }
        }
        return aliveCount;
    }

    int isAlive(int state) {
        // if the next state is alive that means the current state is dead
        if(state == 0 || state == nextStateAlive)
            return 0;
        return 1;
    }

    // Only changes the state if different from current state
    int nextState(int currentState, int aliveCount) {
        if(currentState == 0)
            if(aliveCount == 3)
                return nextStateAlive;
            else
                return 0;
        if(aliveCount == 2 || aliveCount == 3)
            return 1;
        return nextStateDead;
    }

    int finalState(int currentState) {
        if(currentState == 0 || currentState == nextStateDead)
            return 0;
        return 1;
    }
}
