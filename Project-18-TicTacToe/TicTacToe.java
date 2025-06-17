import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        printBoard();

        while (!gameEnded) {
            System.out.println("🎯 Player " + currentPlayer + ", enter (1-9): ");
            int pos = sc.nextInt();

            while (!isValid(pos)) {
                System.out.println("❌ Invalid or already taken. Try again: ");
                pos = sc.nextInt();
            }

            placeMove(pos, currentPlayer);
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("🏆 Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("🤝 It's a draw!");
                gameEnded = true;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean isValid(int pos) {
        int[] coord = getCoord(pos);
        return board[coord[0]][coord[1]] == ' ';
    }

    public static void placeMove(int pos, char player) {
        int[] coord = getCoord(pos);
        board[coord[0]][coord[1]] = player;
    }

    public static int[] getCoord(int pos) {
        return switch (pos) {
            case 1 -> new int[]{0, 0};
            case 2 -> new int[]{0, 2};
            case 3 -> new int[]{0, 4};
            case 4 -> new int[]{2, 0};
            case 5 -> new int[]{2, 2};
            case 6 -> new int[]{2, 4};
            case 7 -> new int[]{4, 0};
            case 8 -> new int[]{4, 2};
            case 9 -> new int[]{4, 4};
            default -> new int[]{-1, -1};
        };
    }

    public static boolean checkWin(char player) {
        return (checkLine(0, 0, 0, 2, 0, 4, player) || // Row 1
                checkLine(2, 0, 2, 2, 2, 4, player) || // Row 2
                checkLine(4, 0, 4, 2, 4, 4, player) || // Row 3
                checkLine(0, 0, 2, 0, 4, 0, player) || // Col 1
                checkLine(0, 2, 2, 2, 4, 2, player) || // Col 2
                checkLine(0, 4, 2, 4, 4, 4, player) || // Col 3
                checkLine(0, 0, 2, 2, 4, 4, player) || // Diag \
                checkLine(0, 4, 2, 2, 4, 0, player));  // Diag /
    }

    public static boolean checkLine(int r1, int c1, int r2, int c2, int r3, int c3, char p) {
        return board[r1][c1] == p && board[r2][c2] == p && board[r3][c3] == p;
    }

    public static boolean isBoardFull() {
        for (int i = 1; i <= 9; i++) {
            int[] coord = getCoord(i);
            if (board[coord[0]][coord[1]] == ' ')
                return false;
        }
        return true;
    }
}
